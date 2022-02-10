#!/bin/bash

set -e

ssh root@web1.topobyte.de touch /opt/tomcat/tomcat-secure/rootapps/example-webapp/ROOT.war
