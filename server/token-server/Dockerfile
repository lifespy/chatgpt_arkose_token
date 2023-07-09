FROM findepi/graalvm:java17-native

MAINTAINER xiubbs

RUN mkdir -p /chatgpt_cms/server/logs \
    /chatgpt_cms/server/temp

WORKDIR /chatgpt_cms/server

ENV SERVER_PORT=8080

EXPOSE ${SERVER_PORT}

ADD ./target/token-server.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
            "-jar", "app.jar"]
