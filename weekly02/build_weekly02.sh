#!/bin/bash

PATHSEP=":"
if [[ $OS == "Windows_NT" ]] || [[ $OSTYPE == "cygwin" ]]
then
    PATHSEP=";"
fi

echo -e "\n=========="
echo -e "${0}: Compiling program..."
if [ ! -f "systemet.jar" ]
then
    echo -e "${0}: No jar file found. Fetching...\n"
    ./get_latest_jar.sh
    echo -e "\n\n${0}: Done fetching jar file. Saved as systemet.jar ."
    sleep 1
fi
javac -cp "systemet.jar${PATHSEP}." Weekly02.java
echo -e "==========\n"
