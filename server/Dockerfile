FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/server-0.0.1-SNAPSHOT.jar /app/server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/server.jar"]
