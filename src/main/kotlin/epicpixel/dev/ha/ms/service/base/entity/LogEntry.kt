package epicpixel.dev.ha.ms.service.base.entity
import jakarta.persistence.*
import java.time.Instant

@Entity
data class LogEntry (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    val user: User? = null,

    val createdAt: Instant = Instant.now(),

    @Enumerated(EnumType.STRING)
    val level: LogLevel = LogLevel.INFO,

    val details : String,

)

enum class LogLevel {
    INFO,
    WARNING,
    ERROR,
    DEBUG,
}