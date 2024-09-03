FROM maven:3.9.9 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY pom.xml ./
COPY src ./src

# Package the application (skip tests to speed up the process)
RUN mvn clean package -DskipTests

# Step 2: Runtime Stage
FROM openjdk:24-slim-bullseye

# Set the working directory inside the container


# Copy the JAR file from the build stage to the runtime stage
COPY target/Shoe-Shop-0.0.1-SNAPSHOT.jar Shoe-Shop-0.0.1-SNAPSHOT.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/Shoe-Shop-0.0.1-SNAPSHOT.jar"]
