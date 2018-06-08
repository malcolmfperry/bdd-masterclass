#!/bin/bash
# $1 : tags to run

mvn -Dtest=AcceptanceTests -Dcucumber-options="-t $1" test
