#!/bin/bash
echo "Starting exams-thrift-server in development mode..."

# find jar no matter what the root dir name
SCRIPT_DIR=$(cd `dirname "$0"`; pwd)
ROOT_DIR=`dirname "$SCRIPT_DIR"`

java -server -Xmx1024m -Dstage=development -jar exams-thrift-server_2.10-@VERSION@.jar
