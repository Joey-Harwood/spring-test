FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp
WORKDIR /app

ARG JAR_FILE

RUN apk --update add postgresql-client

COPY ${JAR_FILE} app.jar
COPY ops ./ops

CMD ["java","-jar","/app.jar"]
