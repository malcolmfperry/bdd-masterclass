#!/bin/sh

# Required Maven (i.e. 3.5.0)
# Required JDK 1.8

export PUPPY_WEBSITE=http://puppies.herokuapp.com
export WEBDRIVER_CHROME_DRIVER=$HOME/dev/bin/webdrivers/chromedriver-240

mvn clean
mvn -Dtest=AdoptPetsPOMStyle test
mvn -Dtest=AdoptPetsPFStyle test
