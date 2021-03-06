#!/usr/bin/env bash

bound=`expr $1 - 1`

# SOURCE
if [ "SOURCE" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo SOURCE Node$i
    	ssh node$i "source ~/.bashrc"
	done
fi

# RM
if [ "RM" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo RM Node$i
    	ssh node$i "rm -r ~/dbs/*"
	done
fi

# UPDATE
if [ "UPDATE" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo UPDATE Node$i
    	ssh node$i "cd ~/GTBench; git pull" &
	done
fi

# CLEAN
if [ "CLEAN" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo CLEAN Node$i
    	ssh node$i "cd ~/GTBench; make clean" &
	done
fi

# UPDATE and COMPILE
if [ "UPDATE-COMPILE" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo UPDATE Node$i
    	ssh node$i "cd ~/GTBench; git pull; make all" &
	done
fi

# SNTP
if [ "SNTP" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo SNTP Node$i
    	ssh -t node$i "sudo sntp -s 24.56.178.140" &
	done
fi

# JPS
if [ "JPS" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo JPS Node$i
    	ssh -t node$i "jps"
	done
fi

# File Limits
if [ "LIMIT" = $2 ]; then
	for i in $(seq 0 $bound)
	do
		echo Increase File Open Limit on Node$i
		ssh -t node$i "sudo cp /proj/dirr-PG0/tools/limits.conf /etc/security/limits.conf"
	done
fi

# Remove PID file
if [ "RMPID" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo RM PID file on Node$i
    	ssh node$i "rm /tmp/sgdbsrv.pid"
	done
fi

# Kill Server Process
if [ "KILL" = $2 ]; then
	for i in $(seq 0 $bound)
	do
    	echo Kill on Node$i
    	ssh node$i "pkill java"
	done
fi

