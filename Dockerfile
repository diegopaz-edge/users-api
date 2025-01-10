FROM openjdk:17-alpine

ADD src/main/docker/entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} app.jar
ENTRYPOINT ["./entrypoint.sh"]