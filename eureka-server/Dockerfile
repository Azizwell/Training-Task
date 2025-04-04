FROM openjdk:17
WORKDIR /app
COPY target/eureka-server-0.0.1-SNAPSHOT.jar eureka-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "eureka-service.jar"]


