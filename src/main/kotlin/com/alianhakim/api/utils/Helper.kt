package com.alianhakim.api.utils

import com.alianhakim.api.entity.Users
import com.alianhakim.api.exception.UserNotFoundException
import com.alianhakim.api.repository.UsersRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class Helper {
    fun userNotFound(user: Optional<Users>) {
        if (!user.isPresent) throw UserNotFoundException()
    }

    fun <T> notFoundException(data: Optional<T>) {
        if (!data.isPresent) {
            throw ChangeSetPersister.NotFoundException()
        }
    }
}

