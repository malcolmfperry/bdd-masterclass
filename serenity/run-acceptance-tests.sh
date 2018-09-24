#!/bin/sh

rm -Rf bdd-masterclass

git clone https://github.com/drtran/bdd-masterclass

cd bdd-masterclass/automation
mvn clean install

cd ../serenity
mvn clean

mvn -Dwebdriver.remote.driver=chrome \
	-Dwebsite.url=$WEBSITE_URL \
	-Dwebdriver.remote.url=$SELENIUM_REMOTE_URL \
	-Dtest=AcceptanceTests \
	test 
