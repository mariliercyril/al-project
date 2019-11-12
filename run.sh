#!/bin/sh

cd project1920
cd IntegrationTests

mvn clean install -DskipTests
mvn exec:java

read -p "Press any key to continue... " -n1 -s
