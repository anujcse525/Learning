#!/bin/sh

dir=../lib
jarFile=primeNumbers_TableGenerator-1.0.jar

if [ -z "$1" ]; then
	echo "Missing arguments, exiting..."
	echo "Usage $0 arg<int>"
	exit 1
fi

java -jar $dir/$jarFile $1

