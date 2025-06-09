# Etapa 1: Build com Gradle
FROM gradle:7.5.1-jdk11 AS builder
WORKDIR /app
COPY . .
RUN gradle clean bootJar --no-daemon

# Etapa 2: Runtime
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /app/build/libs/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080