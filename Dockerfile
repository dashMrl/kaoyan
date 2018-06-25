FROM gradle:jdk8-alpine AS builder
WORKDIR /home/gradle/project
COPY . .
USER root
RUN ./gradlew assemble --stacktrace

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=builder /home/gradle/project/build/libs/kaoyan-0.0.1.jar app.jar
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
EXPOSE 3000
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar

