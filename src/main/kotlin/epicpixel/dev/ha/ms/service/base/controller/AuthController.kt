package epicpixel.dev.ha.ms.service.base.controller

import epicpixel.dev.ha.ms.service.base.document.UserDocument
import epicpixel.dev.ha.ms.service.base.dto.AuthResponseDto
import epicpixel.dev.ha.ms.service.base.service.JwtService
import epicpixel.dev.ha.ms.service.base.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(private val userService: UserService, private val jwtService: JwtService) {

    private val log: org.slf4j.Logger = LoggerFactory.getLogger(AuthController::class.java)

    /**
     * Responsible to create authentication of user
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    fun save(@RequestBody userDocument: UserDocument): ResponseEntity<AuthResponseDto> {
        val prefix: String = "[AuthController] (save): "

        log.info("{} starting save new user", prefix)
        try {
            log.info("{} user service saving", prefix)
            val user = userService.save(userDocument)

            log.info("{} jwt service generate token", prefix)
            val access: String = jwtService.generate(user.id.toString(), user.roles.toString(), "ACCESS")

            log.info("{} return with success new user with token", prefix)
            return ResponseEntity.ok(AuthResponseDto(access, user))
        } catch (e: Exception) {
            log.info("{} starting save new user {}", prefix, e.message)
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }
}