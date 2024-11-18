### Reverso Service

#### Description:

* Java 21
* Springboot 3.3.5
* Gradle 8.11

#### Springboot project setup

create .env file with properties:

```
APP_SERVICE_PORT=8080
APP_SERVICE_NAME=app_reverso_service

CLOUD_KAFKA_USERNAME=....
CLOUD_KAFKA_PASSWORD=...
CLOUD_KAFKA_BROKER_URL=....
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
* habr note: https://habr.com/ru/articles/513520/

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

### Cloud kafka

free kafka online - https://www.cloudkarafka.com/ </br>
Free plan: $0 </br>
For testing and development we provide an Apache Kafka server
that's shared between multiple users. </br>
Note that other users' actions may affect your experience on this server.

* Shared cluster
* Topic management
* Max 5 topics with 10 MB data/topic
* Max 28 days retention
* Certificate based authentication
* Consume and produce from Kafka in a UI
* Email and chat support

### How to set up kafka:

link for info - https://customer.cloudkarafka.com/instance </br>
documentation: https://www.cloudkarafka.com/docs/spring.html </br>
Springboot sample: https://github.com/CloudKarafka/springboot-kafka-example </br>

* Hostname with port - url for CLOUD_KAFKA_BROKER_URL
* Default user - username for CLOUD_KAFKA_USERNAME
* oPassword - Password for CLOUD_KAFKA_PASSWORD

### UptimeRobot: Monitor anything

UptimeRobot is a website monitoring service that checks the status of your websites, servers, and other online services
at regular intervals. It notifies you if any of your monitored services go down, helping you to quickly address any
issues and minimize downtime.

link: https://uptimerobot.com/ <br>
tutorial: https://www.youtube.com/watch?v=wP-tFyZhoio <br>
