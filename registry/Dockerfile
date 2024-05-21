FROM openjdk:17-jdk AS builder
COPY target/registry-0.0.1-SNAPSHOT.jar /app/registry.jar
CMD ["java", "-jar", "/app/registry.jar"]