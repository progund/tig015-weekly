#!/bin/bash

commands="tidy wget java javac zip unzip"

for command in $commands
do
    which $command &> /dev/null || echo You must install $command
done
