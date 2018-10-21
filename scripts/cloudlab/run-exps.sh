/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 16 JPS

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 16 UPDATE

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 16 UPDATE-COMPILE

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 16 CLEAN

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 16 -t edgecut -d ~/dbs/

/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 16

~/GTBench/scripts/cloudlab/ClientOps.sh -n 16 -t edgecut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

~/GTBench/scripts/cloudlab/ClientOps.sh -n 16 -t edgecut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 16 -t edgecut -o travel -c 0 -g ~/Documents/p2p-Gnutella04.txt
~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 16 -t edgecut -o atravel -c 0 -g ~/Documents/p2p-Gnutella04.txt



// DIDO
/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 16 -t dido -d ~/dbs/
~/GTBench/scripts/cloudlab/ClientOps.sh -n 16 -t dido -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
~/GTBench/scripts/cloudlab/ClientOps.sh -n 16 -t dido -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt


