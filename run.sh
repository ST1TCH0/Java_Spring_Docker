#!/bin/bash

java -jar /tmp/gateway.jar &
java -jar /tmp/marks.jar &
java -jar /tmp/models.jar &

apache2ctl -D FOREGROUND