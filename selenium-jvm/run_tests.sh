#!/bin/sh

# Required Maven (i.e. 3.5.0)
# Required JDK 1.8

export PUPPY_WEBSITE=http://puppies.herokuapp.com
export WEBDRIVER_CHROME_DRIVER=$HOME/dev/bin/drivers/chromedriver

mvn clean
mvn -Dtest=AdoptPetsPOMStyle -Dlog4j.configurationFile=src/test/resources/log4j2.xml test
mvn -Dtest=AdoptPetsPFStyle -Dlog4j.configurationFile=src/test/resources/log4j2.xml test
