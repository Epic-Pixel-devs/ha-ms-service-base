package epicpixel.dev.ha.ms.service.base.entity
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant

@Document("logs")
data class LogEntry (

    @Id val id: ObjectId = ObjectId(),

    val user: Long? = null, // TODO: trocar por: @DBRef val user: UserDocument? = null,
    val createdAt: Instant = Instant.now(),

    @Field("type") val level: LogLevel = LogLevel.INFO,
    val details : String,

)

enum class LogLevel {
    INFO,
    WARNING,
    ERROR,
    DEBUG,
}