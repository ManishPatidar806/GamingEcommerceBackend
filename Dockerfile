# Use OpenJDK as the base image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy all microservice JAR files
COPY all-jars/API-Gateway-0.0.1-SNAPSHOT.jar /app/
COPY all-jars/AuthenticationService-0.0.1-SNAPSHOT.jar /app/
COPY all-jars/CartHistoryService-0.0.1-SNAPSHOT.jar /app/
COPY all-jars/ForgotPasswordService-0.0.1-SNAPSHOT.jar /app/
COPY all-jars/Payment-0.0.1-SNAPSHOT.jar /app/
COPY all-jars/ProductService-0.0.1-SNAPSHOT.jar /app/
COPY all-jars/ReviewService-0.0.1-SNAPSHOT.jar /app/

# Copy the startup script
COPY start.sh /app/
RUN chmod +x /app/start.sh

# Expose ports for all services
EXPOSE 8080 8081 8082 8083 8084 8085 8086 

# Run the startup script
CMD ["/bin/bash","/app/start.sh"]
