# Use OpenJDK 21 as the base image and install Maven manually
FROM openjdk:21-slim AS build

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Use OpenJDK 21 for the runtime stage
FROM openjdk:21-slim

WORKDIR /app

COPY --from=build /app/target/Gaming_backend-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/Gaming_backend-0.0.1-SNAPSHOT.jar"]
