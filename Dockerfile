FROM openjdk:8-jre-alpine
WORKDIR /app
COPY ./build/libs/kaoyan*.jar app.jar
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
EXPOSE 8080
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar


