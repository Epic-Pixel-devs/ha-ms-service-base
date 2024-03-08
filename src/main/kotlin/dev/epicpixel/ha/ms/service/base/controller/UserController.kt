package dev.epicpixel.ha.ms.service.base.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController() {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    fun health(): ResponseEntity<String> {
//        val anUser = UserDto(1L, "Sample User Name")
//        userRepository.save(anUser.toEntity())
        return ResponseEntity.ok<String>("anUser")
    }
}
