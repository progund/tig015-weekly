#!/bin/bash

PATHSEP=":"
if [[ $OSTYPE == "cygwin" ]] ; then
    PATHSEP=";"
fi

javac -cp "systemet.jar${PATHSEP}." TestWithJar.java
