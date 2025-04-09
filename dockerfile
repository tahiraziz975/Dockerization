# # Use an official OpenJDK runtime as a parent image
# FROM openjdk:17-jdk-slim
#
# # Set the working directory inside the container
# WORKDIR /app
#
# # Copy the built application JAR file to the container
# COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
#
# # Expose the application's port
# EXPOSE 8080
#
# # Command to run the application
# CMD ["java", "-jar", "app.jar"]
FROM openjdk:17-jdk
COPY target/demo-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]