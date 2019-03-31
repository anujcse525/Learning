#!/bin/sh

dir=../target
jarFile=NPrimeTableGenerator-0.0.1-SNAPSHOT.jar

if [ -z "$1" ]; then
	echo "Missing arguments, exiting..."
	echo "Usage $0 arg<int>"
	exit 1
fi

java -jar $dir/$jarFile $1