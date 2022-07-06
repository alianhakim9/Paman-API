package com.alianhakim.api.service.impl

import com.alianhakim.api.entity.PersonalInfo
import com.alianhakim.api.exception.UserNotFoundException
import com.alianhakim.api.model.PersonalInfoRequest
import com.alianhakim.api.model.PersonalInfoResponse
import com.alianhakim.api.model.PersonalInfoUpdateRequest
import com.alianhakim.api.repository.PersonalInfoRepository
import com.alianhakim.api.repository.UsersRepository
import com.alianhakim.api.service.PersonalInfoService
import com.alianhakim.api.utils.ValidationUtil
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonalInfoServiceImpl(
    val repository: PersonalInfoRepository,
    val usersRepository: UsersRepository,
    val validationUtil: ValidationUtil,
) : PersonalInfoService {
    override fun create(request: PersonalInfoRequest): PersonalInfoResponse {
        validationUtil.validate(request)
        val user = usersRepository.findById(request.userId!!).orElseThrow {
            UserNotFoundException()
        }
        val pi = PersonalInfo(
            piPhoneNumber = request.piPhoneNumber!!,
            piAddress = request.piAddress!!,
            piWebsite = request.piWebsite!!,
            piEmail = request.piEmail!!,
            user = user
        )
        pi.createdAt = Date()
        repository.save(pi)
        return convertPiToPiResponse(pi)
    }

    override fun get(id: String): PersonalInfoResponse {
        val pi = repository.findById(id).orElseThrow {
            NotFoundException()
        }
        return convertPiToPiResponse(pi)
    }

    override fun update(id: String, request: PersonalInfoUpdateRequest): PersonalInfoResponse {
        val pi = repository.findById(id).orElseThrow {
            NotFoundException()
        }
        validationUtil.validate(request)
        pi.let {
            it.piEmail = request.piEmail!!
            it.piAddress = request.piAddress!!
            it.piWebsite = request.piWebsite!!
            it.piPhoneNumber = request.piPhoneNumber!!
            it.updatedAt = Date()
            repository.save(it)
        }
        return convertPiToPiResponse(pi)
    }

    override fun delete(id: String) {
        val pi = repository.findById(id).orElseThrow { NotFoundException() }
        repository.delete(pi)
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