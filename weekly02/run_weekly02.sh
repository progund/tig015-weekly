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
    echo -e "\n\n${0}: No XML file found. Fetching..."
    ./get_latest_file.sh
    echo -e "\n\n${0}: Done fetching XML. Saved as resources/sortiment.xml.\n\n"
    sleep 1
    echo -e "${0}: Running the program...\n\n"
fi

java $FLAGS -cp "systemet.jar${PATHSEP}." -Dsortiment-xml-file=resources/sortiment.xml Weekly02
