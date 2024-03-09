package dev.epicpixel.ha.ms.service.base.controller

import dev.epicpixel.ha.ms.service.base.document.UserDocument
import dev.epicpixel.ha.ms.service.base.dto.AuthResponseDto
import dev.epicpixel.ha.ms.service.base.service.JwtService
import dev.epicpixel.ha.ms.service.base.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(private val userService: UserService, private val jwtService: JwtService) {
    /**
     * Responsible to create authentication of user
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    fun save(@RequestBody userDocument: UserDocument): ResponseEntity<AuthResponseDto> {
        try {
            val user = userService.save(userDocument)
            val access: String = jwtService.generate(user.id.toString(), user.roles.toString(), "ACCESS")
            return ResponseEntity.ok(AuthResponseDto(access, user))
        } catch (e: Exception) {
            println(e.message)
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }
}