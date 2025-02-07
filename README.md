## Micronaut 4.7.5 Documentation

- [User Guide](https://docs.micronaut.io/4.7.5/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.7.5/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.7.5/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature tomcat-server documentation

- [Micronaut Tomcat Server documentation](https://micronaut-projects.github.io/micronaut-servlet/latest/guide/index.html#tomcat)


## Feature data-jdbc documentation

- [Micronaut Data JDBC documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/index.html#jdbc)


## Feature testcontainers documentation

- [https://www.testcontainers.org/](https://www.testcontainers.org/)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Useful commands

Following [guide](https://guides.micronaut.io/latest/micronaut-data-jdbc-repository-gradle-groovy.html)

App create command

`mn create-app --build=gradle --jdk=17 --lang=groovy --test=spock --features=data-jdbc,testcontainers,tomcat-server,mysql webmicro.two`

devone database was manually created locally, user table is re-created automatically at each run.

create user script:

`curl -X "POST" "http://localhost:8080/user" \
     -H 'Content-Type: application/json; charset=utf-8' \
     -d $'{ "name": "user one", "admin": false, "loginCount": 0}'`

get users script:

`curl -X "GET" "http://localhost:8080/user/list" \
     -H 'Content-Type: application/json; charset=utf-8'`