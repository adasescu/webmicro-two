package webmicro.two.domain

import groovy.transform.CompileStatic
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
//import io.micronaut.data.annotation.Serdeable // wasn't working probably different jvm version
import io.micronaut.serde.annotation.Serdeable

import jakarta.validation.constraints.NotNull

@CompileStatic
@Serdeable
@MappedEntity
class User {

    @Id
    @GeneratedValue(GeneratedValue.Type.IDENTITY)
    Long id

    String name

    @NotNull
    Boolean admin

    Integer loginCount

    String toString() {
        "User{id=$id, name:'$name', admin:$admin, loginCount:$loginCount}"
    }
}