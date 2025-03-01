#!/bin/bash


nohup java -jar all-jars/API-Gateway-0.0.1-SNAPSHOT.jar --server.port=8080 > logs/apigateway.log 2>&1 &
# Run the JAR files in the background, each on a different port
nohup java -jar all-jars/AuthenticationService-0.0.1-SNAPSHOT.jar --server.port=8081 > logs/Auth.log 2>&1 &
nohup java -jar all-jars/CartHistoryService-0.0.1-SNAPSHOT.jar --server.port=8086 > logs/CartHistory.log 2>&1 &
nohup java -jar all-jars/ForgotPasswordService-0.0.1-SNAPSHOT.jar --server.port=8085 > logs/ForgotPassword.log 2>&1 &
nohup java -jar all-jars/Payment-0.0.1-SNAPSHOT.jar --server.port=8083 > logs/payment.log 2>&1 &
nohup java -jar all-jars/ProductService-0.0.1-SNAPSHOT.jar --server.port=8082 > logs/Product.log 2>&1 &
nohup java -jar all-jars/ReviewService-0.0.1-SNAPSHOT.jar --server.port=8084 > logs/Review.log 2>&1 &


# Wait command to keep the script running and keep services active
wait
