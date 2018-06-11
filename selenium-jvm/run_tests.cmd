REM Required access to Maven software:
REM For example, you may have done this setup already:
REM
REM **** MAVEN 3.5.0 ****
REM SET MAVEN_HOME=%CSD_BIN%\apache-maven-3.5.0
REM SET PATH=%PATH%;%MAVEN_HOME%\bin

REM It also requires you to have access to Java 8 JDK (Preferred).
REM For example:
REM **** JDK ****
REM SET JAVA_HOME=%CSD_BIN%\jdk1.8.0_161
REM SET JRE_HOME=%JAVA_HOME%\jre
REM SET PATH=%JAVA_HOME%\bin;%CSD_BIN%;%PATH%;

SET PUPPY_WEBSITE=http://puppies.herokuapp.com
SET WEBDRIVER_CHROME_DRIVER=c:/csd-work/bin/misc/chromedriver-239.exe

call mvn clean
call mvn -Dtest=AdoptPetsPOMStyle test 
call mvn -Dtest=AdoptPetsPFStyle test