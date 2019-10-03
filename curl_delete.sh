#!/bin/bash

curl http://localhost:8080/files

echo ""
echo "delete file="$1

curl -X DELETE http://localhost:8080/files?name=$1

echo ""
curl http://localhost:8080/files
