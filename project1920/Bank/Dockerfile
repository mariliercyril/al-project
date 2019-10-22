FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD ./target/Bank-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar", "--spring.config.location=classpath:/dockerConfig.properties"]