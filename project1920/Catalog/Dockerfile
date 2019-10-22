FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD ./target/Catalog-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar", "--spring.config.location=classpath:/dockerConfig.properties"]