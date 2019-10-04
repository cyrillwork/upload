#!/bin/bash

#curl http://localhost:8080/files

echo ""
echo "upload file="$1

curl -F file=@$1 http://localhost:8080/files

echo ""
curl http://localhost:8080/files
