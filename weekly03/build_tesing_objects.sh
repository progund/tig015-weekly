#!/bin/bash

bailout() {
    echo $1
    exit 1
}

PATHSEP=":"
if [[ $OS == "Windows_NT" ]] || [[ $OSTYPE == "cygwin" ]]
then
    PATHSEP=";"
fi

./get_latest_file.sh || bailout "Couldn't get xml file"
./get_latest_jar.sh || bailout "Couldn't get systemet.jar"

echo "Compiling TestingObjects.java"
javac -cp "systemet.jar${PATHSEP}." TestingObjects.java
