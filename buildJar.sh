#!/bin/bash
chmod +x ./gradlew
./gradlew clean assemble --stacktrace
docker build -t dashmrl/kaoyan .