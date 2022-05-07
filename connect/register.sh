#!/bin/bash

curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" http://kafka-connect:8083/connectors/ --data @register-connector.json