package dev.epicpixel.ha.ms.service.base.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*
import java.util.Map

@Service
class JwtService {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    @Value("\${jwt.expiration}")
    private lateinit var expiration: String

    private val access: String = "ACCESS"
    private lateinit var key: Key

    @PostConstruct
    fun init() {
        this.key = Keys.hmacShaKeyFor(secret.toByteArray())
    }

    /**
     * Responsible to create new token or refresh token by token type
     */
    fun generate(userId: String, roles: String, tokenType: String): String {
        val claims = Map.of<String, String>("id", userId, "role", roles)
        val expMills = if (access.equals(tokenType, ignoreCase = true)) expiration.toLong() * 1000
        else expiration.toLong() * 1000 * 5

        val now = Date()
        val exp = Date(now.time * expMills)

        return Jwts.builder().setClaims(claims).setSubject(claims["id"]).setIssuedAt(now).setExpiration(exp).signWith(this.key).compact()
    }
}