# Use OpenJDK as the base image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Create the all-jars directory
RUN mkdir -p /app/all-jars

# Copy all JAR files to the container
COPY all-jars/ /app/all-jars/

# Copy the startup script and make it executable
COPY start.sh /app/
RUN chmod +x /app/start.sh

# Expose ports for all microservices
EXPOSE 8080 8081 8082 8083 8084 8085 8086 8761

# Run the startup script
CMD ["/bin/bash", "/app/start.sh"]
