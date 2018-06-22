# blog
This application was generated using JHipster 4.14.4, you can find documentation and help at [http://www.jhipster.tech/documentation-archive/v4.14.4](http://www.jhipster.tech/documentation-archive/v4.14.4).

## Development

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Node.js][]: We use Node to run a development web server and build the project.
   Depending on your system, you can install Node either from source or as a pre-packaged bundle.
2. [Yarn][]: We use Yarn to manage Node dependencies.
   Depending on your system, you can install Yarn either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

    yarn install

We use yarn scripts and [Webpack][] as our build system.


Run the following commands in two separate terminals to create a blissful development experience where your browser
auto-refreshes when files change on your hard drive.

    ./mvnw
    yarn start

[Yarn][] is also used to manage CSS and JavaScript dependencies used in this application. You can upgrade dependencies by
specifying a newer version in [package.json](package.json). You can also run `yarn update` and `yarn install` to manage dependencies.
Add the `help` flag on any command to see how you can use it. For example, `yarn help update`.

The `yarn run` command will list all of the scripts available to run for this project.

### Service workers

Service workers are commented by default, to enable them please uncomment the following code.

* The service worker registering script in index.html

```html
<script>
    if ('serviceWorker' in navigator) {
        navigator.serviceWorker
        .register('./sw.js')
        .then(function() { console.log('Service Worker Registered'); });
    }
</script>
```

Note: workbox creates the respective service worker and dynamically generate the `sw.js`

### Managing dependencies

For example, to add [Leaflet][] library as a runtime dependency of your application, you would run following command:

    yarn add --exact leaflet

To benefit from TypeScript type definitions from [DefinitelyTyped][] repository in development, you would run following command:

    yarn add --dev --exact @types/leaflet

Then you would import the JS and CSS files specified in library's installation instructions so that [Webpack][] knows about them:
Edit [src/main/webapp/app/vendor.ts](src/main/webapp/app/vendor.ts) file:
~~~
import 'leaflet/dist/leaflet.js';
~~~

Edit [src/main/webapp/content/css/vendor.css](src/main/webapp/content/css/vendor.css) file:
~~~
@import '~leaflet/dist/leaflet.css';
~~~
Note: there are still few other things remaining to do for Leaflet that we won't detail here.

For further instructions on how to develop with JHipster, have a look at [Using JHipster in development][].

### Using angular-cli

You can also use [Angular CLI][] to generate some custom client code.

For example, the following command:

    ng generate component my-component

will generate few files:

    create src/main/webapp/app/my-component/my-component.component.html
    create src/main/webapp/app/my-component/my-component.component.ts
    update src/main/webapp/app/app.module.ts


## Building for production

To optimize the blog application for production, run:

    ./mvnw -Pprod clean package

This will concatenate and minify the client CSS and JavaScript files. It will also modify `index.html` so it references these new files.
To ensure everything worked, run:

    java -jar target/*.war

Then navigate to [http://localhost:8080](http://localhost:8080) in your browser.

Refer to [Using JHipster in production][] for more details.

## Testing

To launch your application's tests, run:

    ./mvnw clean test

### Client tests

Unit tests are run by [Karma][] and written with [Jasmine][]. They're located in [src/test/javascript/](src/test/javascript/) and can be run with:

    yarn test

UI end-to-end tests are powered by [Protractor][], which is built on top of WebDriverJS. They're located in [src/test/javascript/e2e](src/test/javascript/e2e)
and can be run by starting Spring Boot in one terminal (`./mvnw spring-boot:run`) and running the tests (`yarn run e2e`) in a second one.
### Other tests

Performance tests are run by [Gatling][] and written in Scala. They're located in [src/test/gatling](src/test/gatling) and can be run with:

    ./mvnw gatling:execute

For more information, refer to the [Running tests page][].

## Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mysql database in a docker container, run:

    docker-compose -f src/main/docker/mysql.yml up -d

To stop it and remove the container, run:

    docker-compose -f src/main/docker/mysql.yml down

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

    ./mvnw verify -Pprod dockerfile:build

Then run:

    docker-compose -f src/main/docker/app.yml up -d

For more information refer to [Using Docker and Docker-Compose][], this page also contains information on the docker-compose sub-generator (`jhipster docker-compose`), which is able to generate docker configurations for one or several JHipster applications.

## Continuous Integration (optional)

To configure CI for your project, run the ci-cd sub-generator (`jhipster ci-cd`), this will let you generate configuration files for a number of Continuous Integration systems. Consult the [Setting up Continuous Integration][] page for more information.

[JHipster Homepage and latest documentation]: http://www.jhipster.tech
[JHipster 4.14.4 archive]: http://www.jhipster.tech/documentation-archive/v4.14.4

[Using JHipster in development]: http://www.jhipster.tech/documentation-archive/v4.14.4/development/
[Using Docker and Docker-Compose]: http://www.jhipster.tech/documentation-archive/v4.14.4/docker-compose
[Using JHipster in production]: http://www.jhipster.tech/documentation-archive/v4.14.4/production/
[Running tests page]: http://www.jhipster.tech/documentation-archive/v4.14.4/running-tests/
[Setting up Continuous Integration]: http://www.jhipster.tech/documentation-archive/v4.14.4/setting-up-ci/

[Gatling]: http://gatling.io/
[Node.js]: https://nodejs.org/
[Yarn]: https://yarnpkg.org/
[Webpack]: https://webpack.github.io/
[Angular CLI]: https://cli.angular.io/
[BrowserSync]: http://www.browsersync.io/
[Karma]: http://karma-runner.github.io/
[Jasmine]: http://jasmine.github.io/2.0/introduction.html
[Protractor]: https://angular.github.io/protractor/
[Leaflet]: http://leafletjs.com/
[DefinitelyTyped]: http://definitelytyped.org/

## Some additional changes (Kiet Tran)

I've made some changes for the following deploying as a container in Openshift.

* create and starts a mysql instance in the Openshift
* rebuild the webpack
* build the production
* build a docker image
* test run it
* push it to the public hub
* pull it down for openshift
* deploy it as a new app in openshift
* verify it works

``` bash
oc new-app -e MYSQL_USER=user -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=password registry.access.redhat.com/openshift3/mysql-55-rhel7
oc get all -o name | grep mysql
oc expose service mysql-55-rhel7
oc describe route mysql-55-rhel7 | grep -i endpoint
```

You can use hostname: `mysql-55-rhel7-myproject.127.0.0.1.nip.io` or ip address 
`172.17.0.3`

``` bash

yarn install && yarn webpack:build
./mvnw -Dmaven.test.skip=true -Pprod install
sudo docker build -t exblog:latest .
sudo docker run -it --env MYSQL_HOST_IP=172.17.0.3 --env MYSQL_ROOT_PASSWORD=password exblog:latest
sudo docker ps | grep -i exblog (this command prints a container id, say 9ee8....)
sudo docker inspect 9ee8 | grep -i ip (get ip address of the running container)

```

* You can visit the website @ http://ip:8080/exblog/#
* Make sure the website work as expected.

You must have an account with Docker Hub in order to push images into the repository.
I have an account with docker hub (drtran).

``` bash
sudo docker tag exblog:latest drtran/exblog:latest
sudo docker push drtran/exblog:latest
```

Assuming that you already have openshift runs in your local box:

``` bash
sudo oc cluster up
```

Then,

``` bash
oc login -u system:admin
oc import-image drtran/exblog --from drtran/exblog --insecure --confirm=true --all=true
oc adm policy add-scc-to-user anyuid -z default
oc new-app -e MYSQL_HOST_IP=172.17.0.3 -e MYSQL_ROOT_PASSWORD=password exblog
oc get all -o name | grep exblog
oc logs -f pods/exblog-x-xxxxx (tail the logs from the pod)
oc expose svc exblog
oc describe route exblog | grep Host (this is your hostname)
```

Visit this website after obtaining the host name (it may be different in your case...)
`http://exblog-myproject.127.0.0.1.nip.io/exblog/#/`

Deploying a tomcat on the Openshift requires this command as you saw:

``` bash
oc adm policy add-scc-to-user anyuid -z default
```

You can try to build a docker container using Wildfly instead. Then, you do not need
to add `anyuid` to the policy

## Building Docker Container using openshift/wildfly-101-centos7 image

Before you build it, you need to make sure this file, `jboss-deployment-structure.xml` is located in either WEB-INF folder. the content of this file should be:

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<jboss-deployment-structure>
    <deployment>
        <exclude-subsystems>
            <subsystem name="logging" />
        </exclude-subsystems>
    </deployment>
</jboss-deployment-structure>
```

I noticed that this command did not generate production code. This causes trouble during the deployment in both tomcat and wildfly.

``` bash
./mvnw -Dmaven.test.skip=true -Pprod clean install
```

Instead, I ended up doing this:

``` bash
./mvnw -Dmaven.test.skip=true -Pprod clean
./mvnw -Dmaven.test.skip=true -Pprod 
./mvnw -Dmaven.test.skip=true -Pprod install
```

``` bash
sudo docker build -f ./Dockerfile_Wildfly -t exblog4wf:latest .
sudo docker run -it --env MYSQL_HOST_IP=172.17.0.3 --env MYSQL_ROOT_PASSWORD=password exblog4wf:latest
```

The server is up and running but the app fails. At this time, I do not know why the deployment to jboss wildfly is not working properly.
