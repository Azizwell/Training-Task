FROM openjdk:17
WORKDIR /app
COPY target/API_Gateway-0.0.1-SNAPSHOT.jar api-gateway-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-gateway-service.jar"]

