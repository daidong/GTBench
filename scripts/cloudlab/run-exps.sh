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

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t edgecut -d ~/dbs/dbs-amazon0302/
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt

~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 8 -t edgecut -o travel -c 0 -g ~/Documents/p2p-Gnutella04.txt
~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 8 -t edgecut -o atravel -c 0 -g ~/Documents/p2p-Gnutella04.txt



// dido
/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t dido -d ~/dbs/
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt


// vertexcut
/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t vertexcut -d ~/dbs/
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt


// giga
/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t giga -d ~/dbs/
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
