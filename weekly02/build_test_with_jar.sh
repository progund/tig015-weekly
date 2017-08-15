#!/bin/bash

PATHSEP=":"
if [[ $OS == "Windows_NT" ]] ; then
    PATHSEP=";"
fi

if [ ! -f "systemet.jar" ]
then
    ./get_latest_jar.sh
fi

javac -cp "systemet.jar${PATHSEP}." TestWithJar.java
