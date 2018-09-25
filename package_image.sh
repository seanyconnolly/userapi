#!/usr/bin/env bash

mvn clean package;

docker build -t suirtech/user-app:latest .

docker push suirtech/user-app