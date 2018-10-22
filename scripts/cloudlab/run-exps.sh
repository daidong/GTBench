#!/usr/bin/env bash

# /users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 JPS
# /users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 UPDATE
# /users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 UPDATE-COMPILE
# /users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 CLEAN
# /users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 RM
# /users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8

# This is a script to run all the tests and collect the results.
# Test-Case 1: Run on 8 r320 nodes to check the performance of BFS with prefetching enabled.

## Case 1: edgecut
echo "Case 1: EdgeCut"
/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 RM
sleep 5

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t edgecut -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t edgecut -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t edgecut -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o travel-4 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t edgecut -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o travel-8 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30




#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o atravel-8 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o travel-4 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t edgecut -o atravel-4 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
#
#~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 8 -t edgecut -o travel -c 0 -g ~/Documents/p2p-Gnutella04.txt
#~/Documents/gitrepos/GTBench/scripts/LocalClientOps.sh -n 8 -t edgecut -o atravel -c 0 -g ~/Documents/p2p-Gnutella04.txt


## Case 2: vertexcut
echo "Case 2: VertexCut"
/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 RM
sleep 5

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t vertexcut -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t vertexcut -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t vertexcut -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o travel-4 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t vertexcut -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o travel-8 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30


## Case 3: dido
echo "Case 3: DIDO"
/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 RM
sleep 5

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t dido -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t dido -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t dido -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o travel-4 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t dido -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o travel-8 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

## Case 4: giga
echo "Case 1: GIGA"
/users/dirruncc/GTBench/scripts/cloudlab/Utils.sh 8 RM
sleep 5

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t giga -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t giga -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t giga -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o travel-4 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30

/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t giga -d ~/dbs/
sleep 30
~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o travel-8 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
sleep 10
/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
sleep 30


#// dido
#/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t dido -d ~/dbs/
#/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t dido -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt


# // vertexcut
# /users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t vertexcut -d ~/dbs/
# ~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
# ~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
# ~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt

# ~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
# ~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o travel-4 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
# ~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t vertexcut -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt


#// giga
#/users/dirruncc/GTBench/scripts/cloudlab/StartServer.sh -n 8 -t giga -d ~/dbs/
#/users/dirruncc/GTBench/scripts/cloudlab/StopServer.sh -n 8
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/p2p-Gnutella04.txt
#
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o insert-graph -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o travel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt
#~/GTBench/scripts/cloudlab/ClientOps.sh -n 8 -t giga -o atravel-2 -c 0 -g /proj/dirr-PG0/datasets/amazon0302.txt