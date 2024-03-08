package dev.epicpixel.ha.ms.service.base.controller

import dev.epicpixel.ha.ms.service.base.document.UserDocument
import dev.epicpixel.ha.ms.service.base.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(private val userService: UserService) {

    /**
     * Responsible to create authentication of user
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    fun save(@RequestBody userDocument: UserDocument): ResponseEntity<UserDocument> {
        return ResponseEntity.ok(userService.save(userDocument))
    }

}