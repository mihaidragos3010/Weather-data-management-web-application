FROM maven:3.8.5-openjdk-17

WORKDIR /app

COPY pom.xml .
COPY src ./src


