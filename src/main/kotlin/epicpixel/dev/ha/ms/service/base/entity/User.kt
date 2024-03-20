package epicpixel.dev.ha.ms.service.base.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val email: String,
    var password: String,

    @Enumerated(EnumType.STRING)
    val type: UserType = UserType.REGULAR,

    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = createdAt,
)

enum class UserType{
    ADMIN,
    REGULAR,
}



