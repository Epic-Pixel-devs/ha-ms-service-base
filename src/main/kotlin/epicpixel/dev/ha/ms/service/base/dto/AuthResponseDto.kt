package epicpixel.dev.ha.ms.service.base.dto

import epicpixel.dev.ha.ms.service.base.document.UserDocument

data class AuthResponseDto(
        val token: String,
        val user: UserDocument
)