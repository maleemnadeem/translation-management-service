# Stage 1: Build the application using Maven
FROM eclipse-temurin:21-jdk AS builder

# Install Maven manually
RUN apt-get update && apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy Maven files
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a lightweight JRE
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the jar from the builder stage
COPY --from=builder /app/target/translation-management-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
