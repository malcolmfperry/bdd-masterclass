#!/bin/sh

export PUPPY_WEBSITE=http://puppies.herokuapp.com
export WEBDRIVER_CHROME_DRIVER=/home/kiet/dev/bin/webdrivers/chromedriver-240

mvn clean
mvn -Dtest=AdoptPetsPOMStyle test

