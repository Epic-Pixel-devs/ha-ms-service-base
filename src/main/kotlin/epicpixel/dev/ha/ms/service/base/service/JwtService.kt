package epicpixel.dev.ha.ms.service.base.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*
import java.util.Map

@Service
class JwtService {
    private val log: org.slf4j.Logger = LoggerFactory.getLogger(JwtService::class.java)

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    @Value("\${jwt.expiration}")
    private lateinit var expiration: String

    private val access: String = "ACCESS"
    private lateinit var key: Key

    /**
     * Responsible to initialize value default java security key
     */
    @PostConstruct
    fun init() {
        log.info("[JwtService] (init): start security key to jwt")
        this.key = Keys.hmacShaKeyFor(secret.toByteArray())
    }

    /**
     * Responsible to create new token or refresh token by token type
     */
    fun generate(userId: String, roles: String, tokenType: String): String {
        val prefix = "[JwtService] (generate): "

        log.info("{} get claims to insert in jwt token", prefix)
        val claims = Map.of<String, String>("id", userId, "role", roles)

        log.info("{} check type token access or refresh", prefix)
        val expMills = if (access.equals(tokenType, ignoreCase = true)) expiration.toLong() * 1000
        else expiration.toLong() * 1000 * 5

        log.info("{} create datetime to expired token", prefix)
        val now = Date()
        val exp = Date(now.time * expMills)

        log.info("{} create new token", prefix)
        return Jwts.builder().setClaims(claims).setSubject(claims["id"]).setIssuedAt(now).setExpiration(exp).signWith(this.key).compact()
    }
}