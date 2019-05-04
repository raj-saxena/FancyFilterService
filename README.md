# FancyFilterService

### Content
* [About](docs/about.md)


### Running
* Start DB with 
```bash
docker-compose -f src/main/resources/docker-compose.yml up
```

* DB migration - Flyway migration runs automatically as part of `build` stage. It can be manually run by
```bash
./gradlew flywayMigrate
```

* JooqCodeGeneration - Runs as part of `build` after flywayMigration. It can be manually run by 
```bash
./gradlew generateFancyFilterAppJooqSchemaSource
```
