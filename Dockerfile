FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]