#!/bin/bash

if [[ -f "systemet.jar" ]]
then
    rm systemet.jar
fi
wget --no-check-certificate  'https://github.com/progund/tig015-weekly/raw/master/beverages-framework/systemet.jar'
