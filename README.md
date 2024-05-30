# Reverso Service

##### Description:

* Java 21
* Springboot 3.3.0
* Gradle 8.7

### Springboot project setup

create .env file with properties:

```
APP_SERVICE_PORT=8080
APP_SERVICE_NAME=app-name
CLOUD_KAFKA_USERNAME
CLOUD_KAFKA_PASSWORD
CLOUD_KAFKA_BROKER_URL
POSTGRESQL_HOSTNAME
POSTGRESQL_DBNAME
POSTGRESQL_USER
POSTGRESQL_PASSWORD
```

### Gradle Versions Plugin

Displays a report of the project dependencies that are up-to-date, exceed the latest version found, have upgrades, or
failed to be resolved, info: https://github.com/ben-manes/gradle-versions-plugin

command:

```
gradle dependencyUpdates
```

### Java code style

Java code style refers to the conventions and guidelines that developers follow when writing Java code to ensure
consistency and readability.

project: google-java-format,
link: https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config

### PostgreSQL

For testing, you can use a free PostgreSQL database - https://www.elephantsql.com/

Service uses **Postgresql** database and **r2dbc** reactive protocol

## Docker

Info: https://hub.docker.com/_/postgres

**database version**: 16
**command**: docker pull postgres:16

start a postgres instance:

```
    $ docker run -d \
    --name postgres-v16-db \
    -e POSTGRES_PASSWORD=password \
    -e POSTGRES_USER=user \
    -e POSTGRES_DB=db \
    postgres:16
```

one-line command

```
docker run -d -p 5432:5432 --name postgres-v16-db -e POSTGRES_PASSWORD=password -e POSTGRES_USER=user -e POSTGRES_DB=db postgres:16
```

Note:
The default postgres user and database are created in the entrypoint with initdb.
