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

if [[ ! -f "systemet.jar" ]]
then
   ./get_latest_jar.sh || bailout "Couldn't get systemet.jar"
fi
   
if [[ ! -f "systemet.jar" ]]
then
    echo -e "${0}: No jar file found. Fetching...\n"
    ./get_latest_file.sh || bailout "Couldn't get xml file"
    echo -e "\n\n${0}: Done fetching jar file. Saved as systemet.jar ."
    sleep 1
fi

echo "Compiling TestingObjects.java"
javac -cp "systemet.jar${PATHSEP}." TestingObjects.java
