/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 3 JPS

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 3 UPDATE

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 3 UPDATE-COMPILE

/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 3 CLEAN

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 3 -t edgecut -d ~/dbs/

/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 3

~/GTBench/scripts/cloudlab/ClientOps.sh -n 3 -t edgecut -o travel -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 3 -t edgecut -o travel -c 0 -g ~/Documents/p2p-Gnutella04.txt
~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 3 -t edgecut -o atravel -c 0 -g ~/Documents/p2p-Gnutella04.txt