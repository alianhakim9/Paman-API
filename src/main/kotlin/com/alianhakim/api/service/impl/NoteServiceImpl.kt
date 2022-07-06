package com.alianhakim.api.service.impl

import com.alianhakim.api.entity.Note
import com.alianhakim.api.exception.UserNotFoundException
import com.alianhakim.api.model.NoteRequest
import com.alianhakim.api.model.NoteResponse
import com.alianhakim.api.model.NoteUpdateRequest
import com.alianhakim.api.repository.NoteRepository
import com.alianhakim.api.repository.UsersRepository
import com.alianhakim.api.service.NoteService
import com.alianhakim.api.utils.ValidationUtil
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteServiceImpl(
    val repository: NoteRepository,
    val usersRepository: UsersRepository,
    val validationUtil: ValidationUtil,
) : NoteService {
    override fun create(request: NoteRequest): NoteResponse {
        validationUtil.validate(request)
        val user = usersRepository.findById(request.userId!!).orElseThrow {
            UserNotFoundException()
        }
        val note = Note(
            noteTitle = request.noteTitle!!,
            noteDescription = request.noteDescription!!,
            user = user,
        )
        note.createdAt = Date()
        repository.save(note)
        return convertNoteToNoteResponse(note)
    }

    override fun get(id: String): NoteResponse {
        val note = repository.findById(id).orElseThrow {
            NotFoundException()
        }
        return convertNoteToNoteResponse(note)
    }

    override fun update(id: String, request: NoteUpdateRequest): NoteResponse {
        val note = repository.findById(id).orElseThrow {
            NotFoundException()
        }
        note.let {
            it.noteTitle = request.noteTitle
            it.noteDescription = request.noteDescription
            it.updatedAt = Date()
            repository.save(it)
        }
        return convertNoteToNoteResponse(note)
    }

    override fun delete(id: String) {
        val note = repository.findById(id).orElseThrow {
            NotFoundException()
        }
        repository.delete(note)
    }

    override fun getByUserId(userId: String): List<NoteResponse> {
        return repository.findByUserId(userId).map {
            convertNoteToNoteResponse(it)
        }
    }

    private fun convertNoteToNoteResponse(note: Note): NoteResponse {
        return NoteResponse(
            id = note.id.toString(),
            noteTitle = note.noteTitle,
            noteDescription = note.noteDescription,
            createdAt = note.createdAt.toString(),
            updatedAt = note.updatedAt.toString()
        )
    }
}