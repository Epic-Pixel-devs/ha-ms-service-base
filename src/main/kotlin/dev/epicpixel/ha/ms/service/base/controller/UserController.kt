package dev.epicpixel.ha.ms.service.base.controller

import dev.epicpixel.ha.ms.service.base.document.UserDocument
import dev.epicpixel.ha.ms.service.base.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/login")
class UserController(private val userService: UserService) {


    @PostMapping("/new-user")
    @ResponseStatus(HttpStatus.OK)
    fun save(@RequestBody userDocument: UserDocument): ResponseEntity<UserDocument> {
        return ResponseEntity.ok(userService.save(userDocument))
    }

    /**
     * Responsible to find all user on database
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    fun users(): ResponseEntity<List<UserDocument>> {
        return ResponseEntity.ok(userService.findAll())
    }
}
