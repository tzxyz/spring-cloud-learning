#!/usr/bin/env bash

nohup mvn spring-boot:run -Dspring.cloud.config.profile=prod1 > eureka-server-1.log &

nohup mvn spring-boot:run -Dspring.cloud.config.profile=prod2 > eureka-server-2.log &

nohup mvn spring-boot:run -Dspring.cloud.config.profile=prod3 > eureka-server-3.log &
