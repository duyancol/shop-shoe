

# Step 2: Runtime Stage
FROM openjdk:24-slim-bullseye

# Set the working directory inside the container


# Copy the JAR file from the build stage to the runtime stage
COPY target/Shoe-Shop-0.0.1-SNAPSHOT.jar Shoe-Shop-0.0.1-SNAPSHOT.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/Shoe-Shop-0.0.1-SNAPSHOT.jar"]
