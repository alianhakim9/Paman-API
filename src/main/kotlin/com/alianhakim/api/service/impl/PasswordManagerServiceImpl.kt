package com.alianhakim.api.service.impl

import com.alianhakim.api.entity.PasswordManager
import com.alianhakim.api.exception.UnAuthorizedException
import com.alianhakim.api.model.PasswordManagerRequest
import com.alianhakim.api.model.PasswordManagerResponse
import com.alianhakim.api.model.PasswordManagerUpdateRequest
import com.alianhakim.api.repository.PasswordManagerRepository
import com.alianhakim.api.repository.UsersRepository
import com.alianhakim.api.service.PasswordManagerService
import com.alianhakim.api.utils.Helper
import com.alianhakim.api.utils.ValidationUtil
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Service
import java.util.*

@Service
class PasswordManagerServiceImpl(
    val repository: PasswordManagerRepository,
    val usersRepository: UsersRepository,
    val validationUtil: ValidationUtil,
    val helper: Helper
) : PasswordManagerService {

    override fun create(request: PasswordManagerRequest): PasswordManagerResponse {
        validationUtil.validate(request)
        val user = usersRepository.findById(request.userId!!)
        helper.userNotFound(user)
        val pm = PasswordManager(
            pmUsername = request.pmUsername!!,
            pmPassword = request.pmPassword!!,
            pmWebsite = request.pmWebsite!!,
            user = user.get(),
        )
        pm.createdAt = Date()
        repository.save(pm)
        return convertPmToPmResponse(pm)
    }

    override fun get(id: String): PasswordManagerResponse {
        val pm = repository.findById(id)
        helper.notFoundException(pm)
        return convertPmToPmResponse(pm.get())
    }

    override fun update(id: String, request: PasswordManagerUpdateRequest): PasswordManagerResponse {
        val pm = repository.findById(id)
        helper.notFoundException(pm)
        pm.get().let {
            it.pmUsername = request.pmUsername
            it.pmPassword = request.pmPassword
            it.pmWebsite = request.pmWebsite
            it.updatedAt = Date()
            repository.save(it)
        }
        return convertPmToPmResponse(pm.get())
    }

    override fun delete(id: String) {
        val pm = repository.findById(id)
        helper.notFoundException(pm)
        repository.delete(pm.get())
    }

    override fun getByUserId(userId: String): List<PasswordManagerResponse> {
        return repository.findByUserId(userId).map {
            convertPmToPmResponse(it)
        }
    }

    private fun convertPmToPmResponse(pm: PasswordManager): PasswordManagerResponse {
        return PasswordManagerResponse(
            id = pm.id.toString(),
            pmUsername = pm.pmUsername,
            pmPassword = pm.pmPassword,
            pmWebsite = pm.pmWebsite,
            createdAt = pm.createdAt.toString(),
            updatedAt = pm.updatedAt.toString()
        )
    }
}