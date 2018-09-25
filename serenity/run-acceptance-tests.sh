#!/bin/bash

git clone https://github.com/drtran/bdd-masterclass

cd bdd-masterclass/automation
mvn install

cd ../serenity
mvn -Dwebdriver.remote.driver=chrome \
	-Dwebsite.url=$WEBSITE_URL \
	-Dwebdriver.remote.url=$SELENIUM_REMOTE_URL \
	-Dtest=AcceptanceTests \
	test 

mvn -DskipTests verify

cp -R target/site/serenity /usr/maven/apache-tomcat-8.5.34/webapps/.
