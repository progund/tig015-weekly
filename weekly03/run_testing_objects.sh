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

echo -n "Running TestingObjects "
if [ $# != 0 ]
then
    echo "Using the argument(s) $@"
else
    echo
fi
java -cp "systemet.jar${PATHSEP}." -Dsortiment-xml-file=resources/sortiment.xml TestingObjects $@
