FROM amazoncorretto:17-alpine

# Set a temporary directory for runtime
VOLUME /tmp

# Copy your Spring Boot JAR file into the container
COPY target/parishservice-0.0.1-SNAPSHOT.jar parishservice-0.0.1-SNAPSHOT.jar

# Define the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/parishservice-0.0.1-SNAPSHOT.jar"]

# Expose the port your application will be running on
EXPOSE 1003
