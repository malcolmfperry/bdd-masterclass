#!/bin/sh

ls -al 

cd bdd-masterclass
git pull https://github.com/drtran/bdd-masterclass

cd automation
mvn clean install

cd ../serenity
mvn clean

mvn -Dwebdriver.remote.driver=chrome \
	-Dwebsite.url="http://puppies.herokuapp.com" \
	-Dwebdriver.remote.url=$SELENIUM_REMOTE_URL \
	-Dtest=AcceptanceTests \
	test 
