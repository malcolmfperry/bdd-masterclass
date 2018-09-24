FROM drtran/bdd-masterclass-serenity-base

WORKDIR /usr/maven

ARG SELENIUM_REMOTE_URL
ARG WEBSITE_URL

COPY run-acceptance-tests.sh .

RUN chmod +x run-acceptance-tests.sh

RUN ./run-acceptance-tests.sh 

CMD ["./run-acceptance-tests.sh"]
