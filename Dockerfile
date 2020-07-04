FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#workspace
WORKDIR /usr/share/test

#add .jar under target from host  into the image
ADD target/Test-Docker.jar        Test-Docker.jar
ADD target/Test-Docker-tests.jar  Test-Docker-tests.jar
ADD target/libs                   libs

# add suite files
ADD book-flight-module.xml       book-flight-module.xml
ADD search-module.xml             search-module.xml

#if in case of any other dependency like .csv /.json /.xls , please add those as well

#Add healthcheck.sh
ADD healthcheck.sh                healthcheck.sh

#BROWSER
#HUB-HOST
#MODULE

ENTRYPOINT sh healthcheck.sh
