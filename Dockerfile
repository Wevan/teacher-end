FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/teacher-end-0.0.1-SNAPSHOT.jar tracking.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tracking.jar"]