#!/usr/bin/env bash

# Note: That date format string only works with gnu date (default on linux) and not at macOS.
# broken timestamp!!
function log_json() {
echo '{ "@timestamp" : "'$(date +%Y-%m-%dT%H:%M:%S.%3NZ)'", "message" : "' "$1" '", "@type" : "service", "@hostname" : "'$HOSTNAME'", "@vertical" : "'$DRP_CF_VERTICAL'", "stage": "'$DRP_CF_STAGE'",  "@service-name" : "'$DRP_CF_SERVICE'", "@service-version" : "'${DRP_CF_VERSION}'","@retention" : "technical", "@trace-id" : "none"}'
}

function log() {
echo "$1"
}

log 'run.sh triggered'

log  "uptime: `uptime`"
log "ls: `ls|tr '\n' ' '`"


java \
-noverify \
-Djava.security.egd=file:/dev/./urandom \
-XX:+UseContainerSupport \
-jar selenium-cucumber-java.jar
