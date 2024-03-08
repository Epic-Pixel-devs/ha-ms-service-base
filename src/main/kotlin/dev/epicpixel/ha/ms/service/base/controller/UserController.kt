package dev.epicpixel.ha.ms.service.base.controller

import dev.epicpixel.ha.ms.service.base.dto.UserDto
import dev.epicpixel.ha.ms.service.base.dto.toEntity
import dev.epicpixel.ha.ms.service.base.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    fun health(): ResponseEntity<UserDto> {
        val anUser = UserDto(1L, "Sample User Name")
        userRepository.save(anUser.toEntity())
        return ResponseEntity.ok<UserDto>(anUser)
    }
}
