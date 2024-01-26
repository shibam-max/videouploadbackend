
# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

 
# Set the working directory in the container
WORKDIR /app
 
# Copy the JAR file from your build system to the container
COPY videolibrarybackend-1-0.0.1-SNAPSHOT.jar /app/videolibrarybackend-1-0.0.1-SNAPSHOT.jar

# Copy the updated application.properties into the container
COPY src/main/resources/application.properties /app/application.properties
 
# Expose the port your application runs on
EXPOSE 8080
 
# Specify the command to run on container start
CMD ["java", "-jar", "videolibrarybackend-1-0.0.1-SNAPSHOT.jar"]
