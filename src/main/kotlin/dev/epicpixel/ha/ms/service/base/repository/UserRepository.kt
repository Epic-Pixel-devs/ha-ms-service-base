package dev.epicpixel.ha.ms.service.base.repository

import dev.epicpixel.ha.ms.service.base.document.UserDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<UserDocument, String> {
    fun findById(id: ObjectId): UserDocument
}
