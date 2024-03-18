package epicpixel.dev.ha.ms.service.base.controller

import epicpixel.dev.ha.ms.service.base.document.UserDocument
import epicpixel.dev.ha.ms.service.base.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    /**
     * Responsible to find all user on database
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun users(): ResponseEntity<List<UserDocument>> {
        return ResponseEntity.ok(userService.findAll())
    }
}
