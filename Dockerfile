FROM openjdk:11-slim
VOLUME /tmp

ARG JAR_FILE
COPY /target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT exec java -jar /app.jar -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS