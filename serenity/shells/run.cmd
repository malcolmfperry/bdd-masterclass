REM 
REM %1: tag to run
mvn -Dtest=AcceptanceTests -Dcucumber.options="-t %1" test
