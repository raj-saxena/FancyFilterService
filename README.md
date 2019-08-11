# FancyFilterService

### Content
* [About](docs/about.md)

### Running
* Start DB with 
```bash
docker-compose -f src/main/resources/docker-compose.yml up
```
___

#### When developing 
(Each next step requires previous to be successful)
* DB migration - Flyway migration runs automatically as part of `build` stage. It can be manually run by
```bash
./gradlew flywayMigrate
```

* JooqCodeGeneration - Runs as part of `build` after flywayMigration. It can be manually run by 
```bash
./gradlew generateFancyFilterAppJooqSchemaSource
```

* Running the tests
```bash
./gradlew build
```

* Running the project - You need to have Jdk installed and `$JAVA_HOME` defined to be able to run the project.
```bash
./gradlew bootRun
```

* Verify that the app is running
```bash
curl localhost:8080/actuator/health
```

#### When as a service
* **After starting DB - Clean, migrate, generate-tables, build, test and start** 
```bash
./gradlew clean flywM generateFancyFilterAppJooqSchemaSource build bootR
```

#### Postman collection for the service
[Postman](./postman)