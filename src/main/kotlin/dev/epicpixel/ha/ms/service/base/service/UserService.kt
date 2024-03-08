package dev.epicpixel.ha.ms.service.base.service

import dev.epicpixel.ha.ms.service.base.document.UserDocument
import dev.epicpixel.ha.ms.service.base.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun save(userDocument: UserDocument): UserDocument {
        userRepository.insert(userDocument)

        return userDocument
    }

    fun findAll(): List<UserDocument> {
        return userRepository.findAll()
    }
}
