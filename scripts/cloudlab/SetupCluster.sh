#!/usr/bin/env bash

bound=`expr $1 - 1`

# Touch Every Server
for i in $(seq 0 $bound)
do
	ssh-keyscan node$i >> ~/.ssh/known_hosts
done

# Install Packages
for i in $(seq 0 $bound)
do
  ssh -t node$i "cd ~; git clone https://github.com/daidong/GTBench.git"
	ssh -t node$i "~/GTBench/scripts/cloudlab//package-installer.sh" &
done