package com.alianhakim.api.service.impl

import com.alianhakim.api.entity.PersonalInfo
import com.alianhakim.api.model.PersonalInfoRequest
import com.alianhakim.api.model.PersonalInfoResponse
import com.alianhakim.api.model.PersonalInfoUpdateRequest
import com.alianhakim.api.repository.PersonalInfoRepository
import com.alianhakim.api.repository.UsersRepository
import com.alianhakim.api.service.PersonalInfoService
import com.alianhakim.api.utils.Helper
import com.alianhakim.api.utils.ValidationUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonalInfoServiceImpl(
    val repository: PersonalInfoRepository,
    val usersRepository: UsersRepository,
    val validationUtil: ValidationUtil,
    val helper: Helper
) : PersonalInfoService {
    override fun create(request: PersonalInfoRequest): PersonalInfoResponse {
        validationUtil.validate(request)
        val user = usersRepository.findById(request.userId!!)
        helper.userNotFound(user)
        val pi = PersonalInfo(
            piPhoneNumber = request.piPhoneNumber!!,
            piAddress = request.piAddress!!,
            piWebsite = request.piWebsite!!,
            piEmail = request.piEmail!!,
            user = user.get()
        )
        pi.createdAt = Date()
        repository.save(pi)
        return convertPiToPiResponse(pi)
    }

    override fun get(id: String): PersonalInfoResponse {
        val pi = repository.findById(id)
        helper.notFoundException(pi)
        return convertPiToPiResponse(pi.get())
    }

    override fun update(id: String, request: PersonalInfoUpdateRequest): PersonalInfoResponse {
        val pi = repository.findById(id)
        validationUtil.validate(request)
        helper.notFoundException(pi)
        pi.get().let {
            it.piEmail = request.piEmail!!
            it.piAddress = request.piAddress!!
            it.piWebsite = request.piWebsite!!
            it.piPhoneNumber = request.piPhoneNumber!!
            it.updatedAt = Date()
            repository.save(it)
        }
        return convertPiToPiResponse(pi.get())
    }

    override fun delete(id: String) {
        val pi = repository.findById(id)
        helper.notFoundException(pi)
        repository.delete(pi.get())
    }

    override fun getByUserId(userId: String): List<PersonalInfoResponse> {
        return repository.findByUserId(userId).map {
            convertPiToPiResponse(it)
        }
    }

    private fun convertPiToPiResponse(pi: PersonalInfo): PersonalInfoResponse {
        return PersonalInfoResponse(
            id = pi.id!!,
            piAddress = pi.piAddress,
            piEmail = pi.piEmail,
            piWebsite = pi.piWebsite,
            piPhoneNumber = pi.piPhoneNumber,
            createdAt = pi.createdAt.toString(),
            updatedAt = pi.updatedAt.toString()
        )
    }
}