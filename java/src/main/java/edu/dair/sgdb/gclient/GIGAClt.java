package edu.dair.sgdb.gclient;

import edu.dair.sgdb.gserver.EdgeType;
import edu.dair.sgdb.partitioner.GigaIndex;
import edu.dair.sgdb.thrift.*;
import edu.dair.sgdb.utils.Constants;
import edu.dair.sgdb.utils.JenkinsHash;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.transport.TTransportException;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ConcurrentHashMap;

public class GIGAClt extends AbstractClt {
    public ConcurrentHashMap<ByteBuffer, GigaIndex> gigaMaps;

    public GIGAClt(int port, ArrayList<String> alls) {
        super(port, alls);
        this.gigaMaps = new ConcurrentHashMap<>();
    }

    private GigaIndex get_giga_index_4_vertex(byte[] bsrc) {
        this.gigaMaps.putIfAbsent(
                ByteBuffer.wrap(bsrc),
                new GigaIndex(getHashLocation(bsrc, Constants.MAX_VIRTUAL_NODE), this.serverNum));
        return gigaMaps.get(ByteBuffer.wrap(bsrc));
    }

    private int getServerLoc(byte[] src, byte[] dst) {
        GigaIndex gi = get_giga_index_4_vertex(src);
        JenkinsHash jh = new JenkinsHash();
        int dstHash = Math.abs(jh.hash32(dst));
        int index = gi.giga_get_index_for_hash(dstHash);
        int server = gi.giga_get_server_from_index(index);
        return server;
    }

    @Override
    public List<KeyValue> read(byte[] srcVertex, EdgeType edgeType, byte[] dstKey) throws TException {
        GigaIndex gi = get_giga_index_4_vertex(srcVertex);

        while (true) {
            int target = getServerLoc(srcVertex, dstKey);
            try {
                List<KeyValue> r = this.getClientConn(target).read(ByteBuffer.wrap(srcVertex),
                        ByteBuffer.wrap(dstKey), edgeType.get());
                return r;
            } catch (RedirectException gre) {
                gi.giga_update_bitmap(gre.getBitmap());
            }
        }
    }

    @Override
    public int insert(byte[] srcVertex, EdgeType edgeType, byte[] dstKey, byte[] value) throws TException {
        GigaIndex gi = get_giga_index_4_vertex(srcVertex);
        int retry = 0;
        while (true) {
            int target = getServerLoc(srcVertex, dstKey);
            try {
                this.getClientConn(target).insert(ByteBuffer.wrap(srcVertex),
                        ByteBuffer.wrap(dstKey), edgeType.get(), ByteBuffer.wrap(value));
                return Constants.RTN_SUCC;
            } catch (RedirectException gre) {
                gi.giga_update_bitmap(gre.getBitmap());
            }
            retry++;
            if (retry >= Constants.RETRY) {
                Scanner s = new Scanner(System.in);
                s.next();
            }
        }
    }

    private HashSet<Integer> getAllSrvs() {
        HashSet<Integer> srvs = new HashSet<>();
        for (int i = 0; i < this.serverNum; i++) {
            srvs.add(i);
        }
        return srvs;
    }

    public HashMap<Integer, Integer> getStats() {
        HashMap<Integer, Integer> stats = new HashMap<>();
        HashSet<Integer> reqs = getAllSrvs();
        for (int server : reqs) {
            try {
                List<Dist> r = this.getClientConn(server).get_state();
                for (Dist d : r) {
                    int split = d.getSplitNum();
                    int vertex = d.getVertexNum();
                    if (!stats.containsKey(split)) {
                        stats.put(split, 0);
                    }
                    int v = stats.get(split);
                    stats.put(split, (vertex + v));
                }
            } catch (TException e) {
                e.printStackTrace();
            }
        }
        return stats;
    }

    private HashSet<Integer> getLocs(byte[] src, HashSet<Integer> excludes) {
        GigaIndex gi = get_giga_index_4_vertex(src);
        HashSet<Integer> locs = gi.giga_get_all_servers();
        locs.removeAll(excludes);
        return locs;
    }

    @Override
    public List<KeyValue> scan(byte[] srcVertex, EdgeType edgeType) throws TException {
        GigaIndex gi = get_giga_index_4_vertex(srcVertex);
        List<KeyValue> rtn = new ArrayList<>();
        HashSet<Integer> reqSrvs;
        HashSet<Integer> alreadySentSrvs = new HashSet<>();
        AtomicInteger totalReqs = new AtomicInteger(0);
        
        while (true){
            reqSrvs = getLocs(srcVertex, alreadySentSrvs);
            alreadySentSrvs.addAll(reqSrvs);
            if (totalReqs.get() == 0 && reqSrvs.isEmpty())
                return rtn;
            
            for (int server : reqSrvs){
                totalReqs.incrementAndGet();
                this.workerPool.execute(
                    new thread_scan(server, 
                                    gi, totalReqs, rtn, 
                                    srcVertex, edgeType));
            }
        }
    }

    private class thread_scan implements Runnable {

        List<KeyValue> rtn;
        GigaIndex gi;
        AtomicInteger total;
        int server_id;
        byte[] src;
        EdgeType edge_type;

        public thread_scan(int server_id, GigaIndex gi, AtomicInteger total, List<KeyValue> kvs,
                            byte[] srcVertex, EdgeType edgeType){
            this.server_id = server_id;
            this.gi = gi;
            this.total = total;
            this.rtn = kvs;
            this.src = srcVertex;
            this.edge_type = edgeType;
        }
        
        @Override
        public void run() {
            try {
                GigaScan scan_rtn = getClientConn(server_id).
                    giga_scan(ByteBuffer.wrap(src), edge_type.get(), ByteBuffer.wrap(gi.bitmap));
                
                this.rtn.addAll(scan_rtn.getKvs());
                this.gi.giga_update_bitmap(scan_rtn.getBitmap());
                this.total.getAndDecrement();

            } catch (TTransportException e) {
                e.printStackTrace();
            } catch (TException e) {
                e.printStackTrace();
			}
        }

    }

    @Override
    public List<ByteBuffer> bfs(byte[] srcVertex, EdgeType edgeType, int max_steps) throws TException {
        return null;
    }

    @Override
    public int sync() throws TException {
        return 0;
    }
}
