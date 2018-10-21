package edu.dair.sgdb.gclient;

import edu.dair.sgdb.gserver.EdgeType;
import edu.dair.sgdb.tengine.travel.JSONCommand;
import edu.dair.sgdb.tengine.travel.SingleStep;
import edu.dair.sgdb.thrift.KeyValue;
import edu.dair.sgdb.thrift.TGraphFSServer;
import edu.dair.sgdb.utils.Constants;
import edu.dair.sgdb.utils.GLogger;
import edu.dair.sgdb.utils.JenkinsHash;
import org.apache.thrift.TException;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractClt {

    public TGraphFSServer.Client[] conns;
    public TGraphFSServer.AsyncClient[] asyncClients;

    public ArrayList<String> allSrvs;
    public int port;
    public int serverNum;

    public ExecutorService workerPool;

    public AbstractClt(int port, ArrayList<String> alls) {
        this.allSrvs = alls;
        this.port = port;
        this.serverNum = allSrvs.size();
        this.conns = new TGraphFSServer.Client[this.serverNum];
        this.asyncClients = new TGraphFSServer.AsyncClient[this.serverNum];

        for (int i = 0; i < this.serverNum; i++) {
            String addrPort = this.allSrvs.get(i);
            String addr = addrPort.split(":")[0];
            this.port = Integer.parseInt(addrPort.split(":")[1]);

            //TTransport transport = new TSocket(addr, port);
            TTransport transport = new TFramedTransport(new TSocket(addr, this.port),
                    2 * 1024 * 1024);
            try {
                transport.open();
            } catch (TTransportException e) {
                GLogger.error("FATAL ERROR: Client can not connect to %s:%s", addr, this.port);
                System.exit(0);
            }
            TProtocol protocol = new TBinaryProtocol(transport);
            TGraphFSServer.Client client = new TGraphFSServer.Client(protocol);
            conns[i] = client;

            try {
                asyncClients[i] = new TGraphFSServer.AsyncClient(new TBinaryProtocol.Factory(),
                        new TAsyncClientManager(),
                        new TNonblockingSocket(addr, this.port));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int procs = Runtime.getRuntime().availableProcessors();
        procs = Math.max(procs, 1);
        this.workerPool = Executors.newFixedThreadPool(Constants.WORKER_THREAD_FACTOR * procs);

    }

    public TGraphFSServer.Client getClientConn(int target) throws TTransportException {
        return conns[target];
    }

    public synchronized TGraphFSServer.AsyncClient getAsyncClientConn(int target) throws TTransportException {
        return asyncClients[target];
    }

    abstract public List<KeyValue> read(byte[] srcVertex, EdgeType edgeType, byte[] dstKey) throws TException;

    abstract public int insert(byte[] srcVertex, EdgeType edgeType, byte[] dstKey, byte[] value) throws TException;

    abstract public List<KeyValue> scan(byte[] srcVertex, EdgeType edgeType) throws TException;

    abstract public List<ByteBuffer> bfs(byte[] srcVertex, EdgeType edgeType, int max_steps) throws TException;

    abstract public int sync() throws TException;

    public int bfs_travel(List<SingleStep> travelPlan) throws TException {
        long ts = System.currentTimeMillis();
        long travelId = ts;

        JSONArray array = new JSONArray();
        for (SingleStep ss : travelPlan) {
            JSONObject jo = new JSONObject();
            jo.put("value", ss.genJSON());
            array.add(jo);
        }
        JSONCommand jc = new JSONCommand();
        jc.add("travel_payload", array);
        int serverId = Math.abs((int) travelId) % this.serverNum;
        return getClientConn(serverId).travel_master(travelId, jc.genString());
    }

    public int abfs_travel(List<SingleStep> travelPlan) throws TException {
        long ts = System.currentTimeMillis();
        long travelId = ts;

        JSONArray array = new JSONArray();
        for (SingleStep ss : travelPlan) {
            JSONObject jo = new JSONObject();
            jo.put("value", ss.genJSON());
            array.add(jo);
        }
        JSONCommand jc = new JSONCommand();
        jc.add("travel_payload", array);
        int serverId = Math.abs((int) travelId) % this.serverNum;
        return getClientConn(serverId).async_travel_master(travelId, jc.genString());
    }

    protected int getHashLocation(byte[] src, int serverNum) {
        JenkinsHash jh = new JenkinsHash();
        int hashi = Math.abs(jh.hash32(src));
        return (hashi % serverNum);
    }

}
