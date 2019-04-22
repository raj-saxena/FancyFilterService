# FancyFilterService

### Content
* [About](docs/about.md)


### Running
* Start DB with 
```bash
docker-compose -f src/main/resources/docker-compose.yml up
```

* DB migration - Flyway migration runs automatically after `build` stage. It can be manually run by
```bash
./gradlew flywayMigrate
```   
