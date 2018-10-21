package edu.dair.sgdb.gclient;

import edu.dair.sgdb.gserver.EdgeType;
import edu.dair.sgdb.tengine.travel.GTravel;
import edu.dair.sgdb.thrift.KeyValue;
import edu.dair.sgdb.utils.ArrayPrimitives;
import edu.dair.sgdb.utils.GLogger;
import edu.dair.sgdb.utils.NIOHelper;
import org.apache.commons.cli.*;
import org.apache.thrift.TException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientMain {

    static Options options = new Options();

    //static final MetricRegistry metrics = new MetricRegistry();
    /*
     static {
     ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
     .convertRatesTo(TimeUnit.SECONDS)
     .convertDurationsTo(TimeUnit.MILLISECONDS)
     .build();
     reporter.start(10, TimeUnit.SECONDS);
     }
    
     static final Histogram responseTime = metrics.histogram(MetricRegistry.name(ClientMain.class, "response-time"));
     */

    private static void classPathCheck() {
        // test classpath
        try {
            //test if module dependency is in the classpath.
            Class.forName("edu.dair.sgdb.gclient.ClientMain");
            //test if other dependencies are in the classpath.
            Class.forName("org.apache.commons.lang.WordUtils");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassPath is not well-configured. Please check.");
        }
    }

    private static void buildOptions() {
        // build option tables

        options.addOption(new Option("help", "print this message"));

        options.addOption(Option.builder("type").hasArg()
                .desc("client type indicates the algorithm you want to choose.")
                .build());

        options.addOption(Option.builder("op").hasArg()
                .desc("test operations;")
                .build());

        options.addOption(Option.builder("id").hasArg()
                .desc("ID of the requested vertex")
                .build());

        options.addOption(Option.builder("graph").hasArg()
                .desc("graph file")
                .build());

        options.addOption(Option.builder("srvlist").hasArgs()
                .desc("addresses of all servers")
                .build());

    }

    public static String[] parseArgs(String[] args, List<String> allsrvs) {
        String[] rst = new String[4];
        CommandLineParser parser = new DefaultParser();
        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);

            if (args.length == 0) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("client", options);
                System.exit(0);
            }

            if (line.hasOption("help")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("client", options);
                System.exit(0);
            }

            if (line.hasOption("type")) {
                rst[0] = line.getOptionValue("type", "edgecut");
            } else {
                throw new ParseException("argument 'type' is required.");
            }

            if (line.hasOption("op")) {
                rst[1] = line.getOptionValue("op", "0");
            } else {
                throw new ParseException("argument 'op' is required.");
            }

            if (line.hasOption("id")) {
                rst[2] = line.getOptionValue("id");
            } else {
                throw new ParseException("argument 'id' is required.");
            }

            if (line.hasOption("graph")) {
                rst[3] = line.getOptionValue("graph");
            } else {
                //throw new ParseException("argument 'graph' is required.");
                rst[3] = "";
            }

            if (line.hasOption("srvlist")) {
                String[] srvs = line.getOptionValues("srvlist");
                allsrvs.addAll(Arrays.asList(srvs));
            }
        } catch (ParseException exp) {
            System.out.println("Arguments Error:" + exp.getMessage());
            System.exit(-1);
        }
        return rst;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, TException {
        classPathCheck();

        buildOptions();

        ArrayList<String> allsrvs = new ArrayList<>();

        String[] rst = parseArgs(args, allsrvs);

        String type = rst[0];

        String op = rst[1];

        AbstractClt client = null;

        switch (type) {
            case "edgecut":
                client = new EdgeCutClt(0, allsrvs);
                break;
            case "iogp":
                client = new IOGPClt(0, allsrvs);
                break;
            case "giga":
                client = new GIGAClt(0, allsrvs);
                break;
            case "dido":
                client = new DIDOClt(0, allsrvs);
                break;
            case "vertexcut":
                client = new VertexCutClt(0, allsrvs);
                break;            
            default:
                System.out.println("Undefined Client Type!");
                break;
        }

        String id = rst[2];
        String graphFile = rst[3];

        String line;
        long start = 0;
        BufferedReader br;

        String payload_string = "";
        for (int i = 0; i < 128; i++) payload_string += "aaaaaaaaaa";
        byte[] val = payload_string.getBytes();

        switch (op) {

            case "insert-graph":
                br = new BufferedReader(new FileReader(graphFile));
                int line_num = 0;
                start = System.currentTimeMillis();
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("#"))
                        continue;

                    String[] splits = line.split("\\W+");
                    byte[] src = splits[0].getBytes();
                    byte[] dst = splits[1].getBytes();

                    client.insert(src, EdgeType.OUT, dst, val);
                    client.insert(dst, EdgeType.IN, src, val);
                    line_num += 2;

                    if (line_num % 1000 == 0)
                        GLogger.info("insert %d cost %d",
                                line_num, (System.currentTimeMillis() - start));
                }
                GLogger.info("Insert time: %d", (System.currentTimeMillis() - start));
                break;

            case "insert-100":
                start = System.currentTimeMillis();
                for (int i = 1; i <= 100; i++) {
                    byte[] src = "vertex0".getBytes();
                    byte[] dst = ("vertex" + i).getBytes();

                    client.insert(src, EdgeType.OUT, dst, val);
                    client.insert(dst, EdgeType.IN, src, val);
                }
                GLogger.info("Insert-100 time: %d", (System.currentTimeMillis() - start));
                break;

            case "insert-1000":
                start = System.currentTimeMillis();
                for (int i = 1; i <= 1000; i++) {
                    byte[] src = "vertex0".getBytes();
                    byte[] dst = ("vertex" + i).getBytes();

                    client.insert(src, EdgeType.OUT, dst, val);
                    client.insert(dst, EdgeType.IN, src, val);
                }
                GLogger.info("Insert-1000 time: %d", (System.currentTimeMillis() - start));
                break;

            case "insert-10000":
                start = System.currentTimeMillis();
                for (int i = 1; i <= 10000; i++) {
                    byte[] src = "vertex0".getBytes();
                    byte[] dst = ("vertex" + i).getBytes();

                    client.insert(src, EdgeType.OUT, dst, val);
                    client.insert(dst, EdgeType.IN, src, val);
                }
                GLogger.info("Insert-10000 time: %d", (System.currentTimeMillis() - start));
                break;

            case "insert-100000":
                start = System.currentTimeMillis();
                for (int i = 1; i <= 100000; i++) {
                    byte[] src = "vertex0".getBytes();
                    byte[] dst = ("vertex" + i).getBytes();

                    client.insert(src, EdgeType.OUT, dst, val);
                    client.insert(dst, EdgeType.IN, src, val);
                }
                GLogger.info("Insert-100000 time: %d", (System.currentTimeMillis() - start));
                break;

            case "scan":
                start = System.currentTimeMillis();
                List<KeyValue> r = client.scan((id).getBytes(), EdgeType.OUT);
                GLogger.info("Scan Vertex-%s time: %d return size: %d",
                        id, (System.currentTimeMillis() - start), r.size());
                break;

            case "bfs":
                start = System.currentTimeMillis();
                List<ByteBuffer> rtn = client.bfs((id).getBytes(), EdgeType.OUT, 1);
                GLogger.info("BFS %s cost time: %d Size: %d",
                        id, (System.currentTimeMillis() - start), rtn.size());

                for (ByteBuffer v : rtn) {
                    GLogger.info("Vertex: %s", new String(NIOHelper.getActiveArray(v)));
                }
                break;

            case "travel-2":
                client.sync();
                GLogger.info("Start Travel on vertex %s", id);
                byte[] b2Edge = ArrayPrimitives.itob(EdgeType.OUT.get());
                GTravel g2t = new GTravel();
                g2t.v((id).getBytes());
                for (int i = 0; i < 2; i++) {
                    g2t.et(b2Edge).next();
                }
                g2t.v();
                long cost2 = client.bfs_travel(g2t.plan());
                GLogger.info("Travel-2 BFS from vertex-%s takes: %d ms", id, cost2);
                break;

            case "travel-4":
                client.sync();
                GLogger.info("Start Travel on vertex %s", id);
                byte[] b4Edge = ArrayPrimitives.itob(EdgeType.OUT.get());
                GTravel g4t = new GTravel();
                g4t.v((id).getBytes());
                for (int i = 0; i < 4; i++) {
                    g4t.et(b4Edge).next();
                }
                g4t.v();
                long cost4 = client.bfs_travel(g4t.plan());
                GLogger.info("Travel-2 BFS from vertex-%s takes: %d ms", id, cost4);
                break;

            case "travel-8":
                client.sync();
                GLogger.info("Start Travel on vertex %s", id);
                byte[] b8Edge = ArrayPrimitives.itob(EdgeType.OUT.get());
                GTravel g8t = new GTravel();
                g8t.v((id).getBytes());
                for (int i = 0; i < 8; i++) {
                    g8t.et(b8Edge).next();
                }
                g8t.v();
                long cost8 = client.bfs_travel(g8t.plan());
                GLogger.info("Travel-2 BFS from vertex-%s takes: %d ms", id, cost8);
                break;

            case "atravel-2":
                client.sync();
                GLogger.info("Start Async Travel on vertex %s", id);
                byte[] c2Edge = ArrayPrimitives.itob(EdgeType.OUT.get());
                GTravel ag2t = new GTravel();
                ag2t.v((id).getBytes());
                for (int i = 0; i < 2; i++) {
                    ag2t.et(c2Edge).next();
                }
                ag2t.v();
                long acost2 = client.abfs_travel(ag2t.plan());
                GLogger.info("Travel-2 ABFS from vertex-%s takes: %d ms", id, acost2);
                break;

            case "atravel-4":
                client.sync();
                GLogger.info("Start Async Travel on vertex %s", id);
                byte[] c4Edge = ArrayPrimitives.itob(EdgeType.OUT.get());
                GTravel ag4t = new GTravel();
                ag4t.v((id).getBytes());
                for (int i = 0; i < 4; i++) {
                    ag4t.et(c4Edge).next();
                }
                ag4t.v();
                long acost4 = client.abfs_travel(ag4t.plan());
                GLogger.info("Travel-4 ABFS from vertex-%s takes: %d ms", id, acost4);
                break;

            case "atravel-8":
                client.sync();
                GLogger.info("Start Async Travel on vertex %s", id);
                byte[] c8Edge = ArrayPrimitives.itob(EdgeType.OUT.get());
                GTravel ag8t = new GTravel();
                ag8t.v((id).getBytes());
                for (int i = 0; i < 8; i++) {
                    ag8t.et(c8Edge).next();
                }
                ag8t.v();
                long acost8 = client.abfs_travel(ag8t.plan());
                GLogger.info("Travel-2 ABFS from vertex-%s takes: %d ms", id, acost8);
                break;

            default:
                System.out.println("Undefined Op!");
                break;
        }

    }
}
