package epicpixel.dev.ha.ms.service.base.service

import epicpixel.dev.ha.ms.service.base.document.UserDocument
import epicpixel.dev.ha.ms.service.base.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    private val log: org.slf4j.Logger = LoggerFactory.getLogger(UserService::class.java)

    @Autowired
    lateinit var userRepository: UserRepository

    /**
     * Responsible to save new user on database
     */
    fun save(userDocument: UserDocument): UserDocument {
        val prefix: String = "[UserService] (save): "

        // TODO: before save user
        // TODO: create new class Validator to verify if exists,
        // TODO: validate e-mail with Regex
        // TODO: make crypto password
        log.info("{} call repository to save user", prefix)
        userRepository.insert(userDocument)

        log.info("{} user saved successfully", prefix)
        return userDocument
    }

    /**
     * Responsible to list all user from database
     */
    fun findAll(): List<UserDocument> {
        log.info("[UserService] (save): get all user from database")
        return userRepository.findAll()
    }
}
