#!/bin/bash

if [[ -f "resources/sortiment.xml" ]]
then
    rm resources/sortiment.xml
fi

if [ ! -d "resources" ]
then
    mkdir resources
fi
wget 'https://www.systembolaget.se/api/assortment/products/xml' -O resources/sortiment.xml
tidy -indent -utf8 -xml resources/sortiment.xml > resources/formatted.xml
mv resources/formatted.xml resources/sortiment.xml
