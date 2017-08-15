#!/bin/bash

PATHSEP=":"
if [[ $OS == "Windows_NT" ]] ; then
    PATHSEP=";"
fi

if [ ! -f "resources/sortiment.xml" ]
then
    ./get_latest_file.sh
fi

java -cp "systemet.jar${PATHSEP}." -Dsortiment-xml-file=resources/sortiment.xml TestWithJar
