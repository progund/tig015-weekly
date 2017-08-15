#!/bin/bash

PATHSEP=":"
if [[ $OSTYPE == "cygwin" ]] ; then
    PATHSEP=";"
fi

java -cp "systemet.jar${PATHSEP}." -Dsortiment-xml-file=resources/sortiment.xml TestWithJar
