#!/bin/bash

PACKAGES="se.itu.systemet.domain se.itu.systemet.storage"
javadoc -d ../docs -link  http://docs.oracle.com/javase/8/docs/api/ $PACKAGES
