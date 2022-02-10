#!/bin/bash

set -e

./gradlew clean war

rsync -av web/build/libs/example-webapp-web-0.0.1-production.war \
root@example.com:/opt/tomcat/rootapps/example-webapp/ROOT.war
