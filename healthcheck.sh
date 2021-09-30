#!/usr/bin/env bash
# Environment variables
# HUB_HOST
# BROWSER
# MODULE

echo ">>> Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
  echo "$( curl -s http://$HUB_HOST:4444/wd/hub/status)"
  sleep 1
done

echo
echo ">>> hub is ready"
echo ">>> Call run test module $MODULE HUB_HOST $HUB_HOST BROWSER $BROWSER"
echo

java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
     -DHUB_HOST=$HUB_HOST -DBROWSER=$BROWSER org.testng.TestNG $MODULE

echo
echo ">>> call run test"
echo