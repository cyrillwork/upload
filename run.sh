#!/bin/bash

HOST=localhost/
BD_NAME=upload

java -jar target/upload-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:postgresql://$HOST$BD_NAME
