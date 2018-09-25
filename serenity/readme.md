# Serenity Project 
`2018 (C) Kiet T. Tran, Ph.D.`

I reworked the examples to show a different approach to automate the executable 
specification using Serenity BDD.

## Credits
For this work, I used these web sites extensively. Much credits
go to the folks who are responsible for the sites:

```
http://www.thucydides.info/#/
http://puppies.herokuapp.com/
https://gist.github.com/ziadoz/3e8ab7e944d02fe872c3454d17af31a5
```

Thanks also go to many folks who are working on the open source software that I am using for 
this project.

## Introduction
June 2018: I am using the latest versions of Serenity BDD and many of 
the dependent libraries.

The purpose of this re-implementation is to determine if the new way of writing
the automated tests assists in reading the report.

I want the report to be as readable to the least technical knowledgeable stakeholder.

## Needed environment variable

Jeff Morgan's puppies website running on herokuapp.

My puppies website running on 'free' openshift.

```
PUPPY_WEBSITE=http://puppies.herokuapp.com

or ...

PUPPY_WEBSITE=http://puppies-drtran.7e14.starter-us-west-2.openshiftapps.com/
>>> Free version of openshift --> SLOWWWWWWWWWW
```

Replace my IP address (i.e., 192.168.1.201) to your own IP address.

## Run with local Chrome driver:

```
-Dwebdriver.driver=chrome
-Dwebdriver.chrome.driver=/home/kiet/dev/bin/drivers/chromedriver
-Dcucumber.options="-t @Kiet_WIP"
```



## Run Selenium Server Docker instance

```
docker run --name selenium-hub -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:3.14
```

Debugging with logs:

```
docker logs -f selenium-hub
```
## Run with Remote Chrome driver:

```
-Dwebdriver.remote.driver=chrome
-Dwebdriver.remote.url=http://192.168.1.201:4444/wd/hub
-Dcucumber.options="-t @Kiet_WIP"
```

## Generate a Serenity Report:

```
mvn -DskipTests verify
```

## Run Selenium Server Docker Instance on a Red Hat's OpenShift

```
oc new-app --name selenium-hub selenium/standalone-chrome:3.14
oc expose selenium-hub

oc describe route selenium-hub | grep "Requested Host"

Requested Host:		selenium-hub-myproject.192.168.1.201.nip.io
```


## Build serenity run as a docker image

Two steps involved. 

1. Build base image: 

```
docker build -t drtran/bdd-masterclass-serenity-base -f Dockerfile_compile .

docker push drtran/bdd-masterclass-serenity-base
```

2. Build serenity build image: 

```
docker build --build-arg WEBSITE_URL=http://puppies.herokuapp.com --build-arg SELENIUM_REMOTE_URL=http://selenium-hub-myproject.192.168.1.201.nip.io/wd/hub -t drtran/bdd-masterclass-serenity .

docker push drtran/bdd-masterclass-serenity

```

## Run a build with docker image:

```
docker run -p 8080:8080 -e WEBSITE_URL=http://puppies.herokuapp.com -e SELENIUM_REMOTE_URL=http://selenium-hub-myproject.192.168.1.201.nip.io/wd/hub -it drtran/bdd-masterclass-serenity
```

## Run a build as an app on OpenShift

```
oc new-app --name acceptance-tests -e WEBSITE_URL=http://puppies.herokuapp.com -e SELENIUM_REMOTE_URL=http://selenium-hub-myproject.192.168.1.201.nip.io/wd/hub drtran/bdd-masterclass-serenity

oc expose svc acceptance-tests

```

May need to delete existing acceptance-tests app before creating a new one. Here are commands:

```
oc delete route acceptance-tests
oc delete svc acceptance-tests
oc delete dc acceptance-tests
oc delete is acceptance-tests
```
