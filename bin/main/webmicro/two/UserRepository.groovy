package webmicro.two

import webmicro.two.domain.User
import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.Id
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.PageableRepository

import jakarta.transaction.Transactional
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@JdbcRepository(dialect = Dialect.MYSQL)
abstract class UserRepository implements PageableRepository<User, Long> {

    abstract User save(String name, @NotNull Boolean admin, Integer loginCount)

    @Transactional
    User saveWithException(@NonNull @NotBlank String name, @NotNull Boolean admin, Integer loginCount) {
        save(name, admin, loginCount)
        throw new DataAccessException("Test Exception")
    }

    abstract List<User> findAll()

    abstract long update(@Id @NonNull Long id, String name, @NotNull Boolean admin, Integer loginCount)
}