FROM openjdk:17-alpine
MAINTAINER baeldung.com
EXPOSE 8080
COPY target/helloworld1-0.0.1-SNAPSHOT.jar message-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]
