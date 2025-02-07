package webmicro.two

import webmicro.two.domain.User
import groovy.transform.CompileStatic
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.Status
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

import jakarta.validation.Valid
//import jakarta.validation.constraints.NotBlanks

@CompileStatic
@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/user")
class UserController {

    protected final UserRepository userRepository

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    @Get(uri="/{id}")
    Optional<User> show(Long id) {
        userRepository
            .findById(id)
    }

    @Put 
    HttpResponse update(@Body @Valid UserUpdateCommand command) { 
        userRepository.update(command.id, command.name, command.admin, command.loginCount)

        HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, location(command.id).path)
    }

    @Get('/list') 
    List<User> list(@Valid Pageable pageable) { 
        userRepository.findAll(pageable).content
    }

    @Post 
    HttpResponse<User> save(@Body('name') String name, @Body('admin') Boolean admin, @Body('loginCount') Integer loginCount) {
        User user = userRepository.save(name, admin, loginCount)

        HttpResponse.created(user)
                .headers(headers -> headers.location(location(user)))
    }

    @Post('/ex') 
    HttpResponse<User> saveExceptions(@Body String name, @Body Boolean admin, @Body Integer loginCount) {
        try {
            User user = userRepository.saveWithException(name, admin, loginCount)
            HttpResponse.created(user)
                    .headers(headers -> headers.location(location(user)))
        } catch(DataAccessException ex) {
            return HttpResponse.noContent()
        }
    }

    @Delete('/{id}') 
    @Status(HttpStatus.NO_CONTENT)
    void delete(Long id) {
        userRepository.deleteById(id)
    }

    private static URI location(Long id) { URI.create("/user/$id") }

    private static URI location(User user) { location(user.id) }
}