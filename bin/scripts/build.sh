#!/bin/sh

#set -x # Echo all commands
set -e # Stop on exit code != 0 immediately

java -version

./mvnw -B -DdependencyLocationsEnabled=false verify --settings mvn-settings.xml 2>&1

echo "build.sh has finished."
