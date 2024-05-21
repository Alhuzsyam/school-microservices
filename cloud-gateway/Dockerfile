FROM openjdk:17-jdk AS builder
COPY target/cloud-gateway-0.0.1-SNAPSHOT.jar /app/cloud-gateway.jar
CMD ["java", "-jar", "/app/cloud-gateway.jar"]