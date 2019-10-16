FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD ./target/Account-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar", "--spring.config.location=classpath:/dockerConfig.properties"]