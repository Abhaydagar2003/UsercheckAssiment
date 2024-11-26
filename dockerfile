# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the application JAR file
COPY target/shudeal-0.0.1-SNAPSHOT.jar spring-app.jar

# Expose application port
EXPOSE 8080

# Entry point for the application
ENTRYPOINT ["java", "-jar", "spring-app.jar"]
