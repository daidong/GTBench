/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 JPS

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 UPDATE

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 UPDATE-COMPILE

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 CLEAN

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 RM

/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8


// edgecut
/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t edgecut -d ~/dbs/
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o atravel-8 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o travel-4 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o atravel-4 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt

~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 8 -t edgecut -o travel -c 0 -g ~/Documents/p2p-Gnutella04.txt
~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 8 -t edgecut -o atravel -c 0 -g ~/Documents/p2p-Gnutella04.txt



// dido
/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t dido -d ~/dbs/
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt


// vertexcut
/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t vertexcut -d ~/dbs/
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o travel-4 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt


// giga
/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t giga -d ~/dbs/
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt



DEBUG: 
SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
2018-10-21 22:27:47 625 [INFO] Start Travel on vertex 0 [ClientMain.java:300 -> main(...)]
2018-10-21 22:27:47 784 [INFO] Start Step[0] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 080 [INFO] Finish Step[0] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 081 [INFO] Start Step[1] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 320 [INFO] Finish Step[1] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 320 [INFO] Start Step[2] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 398 [ERROR] Internal error processing travel_start_step
java.util.ConcurrentModificationException
	at java.util.HashMap$HashIterator.nextEntry(HashMap.java:922)
	at java.util.HashMap$KeyIterator.next(HashMap.java:956)
	at edu.dair.sgdb.tengine.TravelLocalReader.filterVertices(TravelLocalReader.java:25)
	at edu.dair.sgdb.tengine.bfs.bfs.travel_start_step(bfs.java:232)
	at edu.dair.sgdb.gserver.BaseHandler.travel_start_step(BaseHandler.java:52)
	at edu.dair.sgdb.thrift.TGraphFSServer$Processor$travel_start_step.getResult(TGraphFSServer.java:2265)
	at edu.dair.sgdb.thrift.TGraphFSServer$Processor$travel_start_step.getResult(TGraphFSServer.java:2245)
	at org.apache.thrift.ProcessFunction.process(ProcessFunction.java:38)
	at org.apache.thrift.TBaseProcessor.process(TBaseProcessor.java:39)
	at org.apache.thrift.server.AbstractNonblockingServer$FrameBuffer.invoke(AbstractNonblockingServer.java:518)
	at org.apache.thrift.server.Invocation.run(Invocation.java:18)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at java.lang.Thread.run(Thread.java:745)
2018-10-21 22:27:48 487 [INFO] Finish Step[2] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 488 [INFO] Start Step[3] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 617 [INFO] Finish Step[3] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 618 [INFO] Start Step[4] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 774 [INFO] Finish Step[4] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 775 [INFO] Start Step[5] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 996 [INFO] Finish Step[5] [Thread.java:745 -> run(...)]
2018-10-21 22:27:48 997 [INFO] Start Step[6] [Thread.java:745 -> run(...)]
2018-10-21 22:27:49 220 [INFO] Finish Step[6] [Thread.java:745 -> run(...)]
2018-10-21 22:27:49 220 [INFO] Start Step[7] [Thread.java:745 -> run(...)]
2018-10-21 22:27:49 446 [INFO] Finish Step[7] [Thread.java:745 -> run(...)]
2018-10-21 22:27:49 447 [INFO] Start Step[8] [Thread.java:745 -> run(...)]
2018-10-21 22:27:49 613 [INFO] Finish Step[8] [Thread.java:745 -> run(...)]
2018-10-21 22:27:49 613 [INFO] Travel Time: 1933 [Thread.java:745 -> run(...)]
2018-10-21 22:27:49 618 [INFO] Travel-8 BFS from vertex-0 takes: 1933 ms [ClientMain.java:309 -> main(...)]