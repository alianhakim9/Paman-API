package com.alianhakim.api.service.impl

import com.alianhakim.api.entity.Note
import com.alianhakim.api.model.NoteRequest
import com.alianhakim.api.model.NoteResponse
import com.alianhakim.api.model.NoteUpdateRequest
import com.alianhakim.api.repository.NoteRepository
import com.alianhakim.api.repository.UsersRepository
import com.alianhakim.api.service.NoteService
import com.alianhakim.api.utils.Helper
import com.alianhakim.api.utils.ValidationUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteServiceImpl(
    val repository: NoteRepository,
    val usersRepository: UsersRepository,
    val validationUtil: ValidationUtil,
    val helper: Helper
) : NoteService {
    override fun create(request: NoteRequest): NoteResponse {
        validationUtil.validate(request)
        val user = usersRepository.findById(request.userId!!)
        helper.userNotFound(user)
        val note = Note(
            noteTitle = request.noteTitle!!,
            noteDescription = request.noteDescription!!,
            user = user.get(),
        )
        note.createdAt = Date()
        repository.save(note)
        return convertNoteToNoteResponse(note)
    }

    override fun get(id: String): NoteResponse {
        val note = repository.findById(id)
        helper.notFoundException(note)
        return convertNoteToNoteResponse(note.get())
    }

    override fun update(id: String, request: NoteUpdateRequest): NoteResponse {
        val note = repository.findById(id)
        helper.notFoundException(note)
        note.get().let {
            it.noteTitle = request.noteTitle
            it.noteDescription = request.noteDescription
            it.updatedAt = Date()
            repository.save(it)
        }
        return convertNoteToNoteResponse(note.get())
    }

    override fun delete(id: String) {
        val note = repository.findById(id)
        helper.notFoundException(note)
        repository.delete(note.get())
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