

FROM openjdk:17-jdk-slim

 

WORKDIR /app
 

COPY videolibrarybackend-1-0.0.1-SNAPSHOT.jar /app/videolibrarybackend-1-0.0.1-SNAPSHOT.jar


COPY src/main/resources/application.properties /app/application.properties
 

EXPOSE 8080
 

CMD ["java", "-jar", "videolibrarybackend-1-0.0.1-SNAPSHOT.jar"]
