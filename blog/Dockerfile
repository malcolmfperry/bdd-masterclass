FROM tomcat:latest

RUN apt-get update && apt-get -y upgrade

WORKDIR /usr/local/tomcat

COPY target/blog-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/exblog.war

EXPOSE 8080
