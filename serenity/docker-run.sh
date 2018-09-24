#!/bin/sh

me = `basename "$0"`

echo "Run like this: "
echo "$basename selenium-remote-url website-url"
echo "ex: $basename http://selenium-hub-myproject.192.168.1.201.nip.io/wd/hub http://puppies.herokuapp.com"

if [-z "$1"] then echo "ERROR: need selenium-remote-url"; exit; fi
if [-z "$2"] then echo "ERROR: need website-url"; exit; fi 

docker run \
	-e "REMOTE_SELENIUM_URL=http://selenium-hub-myproject.192.168.1.201.nip.io/wd/hub" \
	-e "PUPPY_WEBSITE=http://puppies.herokuapp.com" \
	-d drtran/serenity
	
