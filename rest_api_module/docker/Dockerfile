# Spring project is prepared to run on https://render.com/ webservice
#
# Build stage
FROM gradle:8.11-jdk21-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

LABEL org.name="malex"
# Package stage
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /home/gradle/src/rest_api_module/build/libs/rest_api_module-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-jar","/app.jar"]