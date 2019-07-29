FROM registry.infra.bitmart.com/infra/docker/openjdk:8-jdk

ENV JAVA_OPTS '-DLOG_LEVEL=INFO'
ADD build/libs/*.jar /app.jar
