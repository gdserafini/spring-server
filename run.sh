#!/bin/bash

sudo systemctl stop postgresql

docker rm -f serverdb 2>/dev/null

docker run --name serverdb -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_DB=server \
  -v serverdb_data:/var/lib/postgresql/data \
  -d postgres:16.3

mvn spring-boot:run