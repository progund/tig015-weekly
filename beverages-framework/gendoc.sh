#!/bin/bash

PACKAGES="se.itu.tig015.domain se.itu.tig015.storage"
javadoc -d ../docs -link  http://docs.oracle.com/javase/8/docs/api/ $PACKAGES
