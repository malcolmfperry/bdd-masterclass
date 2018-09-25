FROM drtran/bdd-masterclass-serenity-base

WORKDIR /usr/maven


ARG SELENIUM_REMOTE_URL
ARG WEBSITE_URL

COPY run-acceptance-tests.sh .

RUN chmod +x run-acceptance-tests.sh

RUN ./run-acceptance-tests.sh 

RUN rm -Rf bdd-masterclass

CMD nohup ./run-acceptance-tests.sh; \
	cp nohup.out /usr/maven/apache-tomcat-8.5.34/webapps/serenity/.; \
	/usr/maven/apache-tomcat-8.5.34/bin/catalina.sh run
