package dev.epicpixel.ha.ms.service.base.dto

import dev.epicpixel.ha.ms.service.base.document.UserDocument

data class AuthResponseDto(
        val token: String,
        val user: UserDocument
)