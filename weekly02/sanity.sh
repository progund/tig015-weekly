#!/bin/bash

commands="tidy wget java javac zip unzip"

missing=""
for command in $commands
do
    which $command &> /dev/null && echo "$command OK!" || missing="$missing $command"        
done
if [ "" = "$missing" ]
then
    echo -e "\nYou are all set to go!"
else
    echo -e "\nResult:\nYou are missing $missing"
fi
