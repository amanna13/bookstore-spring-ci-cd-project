# Use a lightweight OpenJDK 17 image (suitable for Spring Boot)
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
# The * allows matching any versioned JAR (like bookstore-spring-ci-cd-0.0.1-SNAPSHOT.jar)
COPY target/*.jar app.jar

# Expose port 8080 (default Spring Boot port)
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
