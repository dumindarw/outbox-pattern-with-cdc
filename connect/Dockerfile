FROM bash:4.4

RUN apk update
RUN apk add curl
COPY ./register-connector.json /register-connector.json
COPY ./register.sh /register.sh

HEALTHCHECK CMD curl --fail -H "Accept:application/json" http://kafka-connect:8083/connectors/ -I -o /dev/null -w '%{http_code}\n' -s || exit 1   

CMD ["bash", "/register.sh"]