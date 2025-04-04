FROM openjdk:17
WORKDIR /app
COPY target/company-service-0.0.1-SNAPSHOT.jar company-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "company-service.jar"]


