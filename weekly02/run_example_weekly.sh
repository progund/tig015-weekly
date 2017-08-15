#!/bin/bash

PATHSEP=":"
FLAGS=""
if [[ $OS == "Windows_NT" ]] || [[ $OSTYPE == "cygwin" ]]
then
    PATHSEP=";"
    FLAGS="-Dfile.encoding=UTF-8"
fi

if [ ! -f "resources/sortiment.xml" ]
then
    ./get_latest_file.sh
fi

java $FLAGS -cp "systemet.jar${PATHSEP}." -Dsortiment-xml-file=resources/sortiment.xml ExampleWeekly
