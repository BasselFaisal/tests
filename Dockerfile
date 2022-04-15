FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/docker.jar docker.jar
ENTRYPOINT ["java","-jar","/docker.jar"]