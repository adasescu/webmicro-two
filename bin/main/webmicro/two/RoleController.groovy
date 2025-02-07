package webmicro.two

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/role")
class RoleController {

    @Get(uri="/", produces="text/plain")
    String index() {
        "Example Role Response"
    }
}