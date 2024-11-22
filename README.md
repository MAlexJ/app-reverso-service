### Reverso Proxy Service

Project support communication protocols:

1. http REST api: rest_api_module
2. kafka: kafka_module
3. rabbitMq
4. grpc
5. core: core_module

#### Description:

* Java 23
* Springboot 3.4.0
* Gradle 8.11.1

#### Springboot project setup

create .env file with properties:

```
REST_API_MODULE_PORT=8080
REST_API_MODULE_NAME=app_reverso_rest_module

KAFKA_MODULE_USERNAME=....
KAFKA_MODULE_PASSWORD=...
KAFKA_MODULE_BROKER_URL=....
```

### Gradle

#### Gradle Versions Plugin

Displays a report of the project dependencies that are up-to-date, exceed the latest version found, have upgrades, or
failed to be resolved, info: https://github.com/ben-manes/gradle-versions-plugin

command:

```
gradle dependencyUpdates
```

#### Gradle wrapper

Gradle Wrapper Reference:
https://docs.gradle.org/current/userguide/gradle_wrapper.html

How to Upgrade Gradle Wrapper:
https://dev.to/pfilaretov42/tiny-how-to-upgrade-gradle-wrapper-3obl

```
./gradlew wrapper --gradle-version latest
```

### Java code style

Java code style refers to the conventions and guidelines that developers follow when writing Java code to ensure
consistency and readability.

project: google-java-format,
link: https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config

### Docker

#### Live Remote Debugging

* video tutorial: https://www.youtube.com/watch?v=QuBgmaILdWI
* additional info: https://ealebed.github.io/tags/docker/
* habr info: https://habr.com/ru/articles/513520/

#### IDE setup

Edit configuration >  Run / Debug > Remote > Remote Debugging or Debugging

run java app:

```
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000 -jar target/remote-debugging-spring-boot-application.jar
```

docker:

```
FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/remote-debugging-spring-boot-application.jar app.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000","-jar","/app.jar"]
```

Note:
The default postgres user and database are created in the entrypoint with initdb.

### UptimeRobot: Monitor anything

UptimeRobot is a website monitoring service that checks the status of your websites, servers, and other online services
at regular intervals. It notifies you if any of your monitored services go down, helping you to quickly address any
issues and minimize downtime.

link: https://uptimerobot.com/ <br>
tutorial: https://www.youtube.com/watch?v=wP-tFyZhoio <br>
