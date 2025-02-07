package webmicro.two

import groovy.transform.CompileStatic
import io.micronaut.serde.annotation.Serdeable

import jakarta.validation.constraints.NotNull

@CompileStatic
@Serdeable
class UserUpdateCommand {

    @NotNull
    final Long id

    final String name

    @NotNull
    Boolean admin

    Integer loginCount

    UserUpdateCommand(@NotNull Long id, String name, @NotNull Boolean admin, Integer loginCount) {
        this.id = id
        this.name = name
        this.admin = admin
        this.loginCount = loginCount
    }
}