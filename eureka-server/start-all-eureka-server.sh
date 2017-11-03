#!/usr/bin/env bash

nohup mvn spring-boot:run -Dspring.cloud.config.profile=prod1 &

nohup mvn spring-boot:run -Dspring.cloud.config.profile=prod2 &

nohup mvn spring-boot:run -Dspring.cloud.config.profile=prod3 &