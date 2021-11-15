# Stage 1
FROM maven:3.8.2-jdk-11 AS build
WORKDIR /build
COPY . .
RUN mvn install

# Stage 2
FROM openjdk:11 AS final
WORKDIR /app
COPY --from=build /build/target .
COPY --from=build /build/Procfile .
CMD java -jar guliver-login-api-1.0.0.jar --server.port=$PORT