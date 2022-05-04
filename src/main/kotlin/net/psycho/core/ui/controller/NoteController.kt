package net.psycho.core.ui.controller

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import net.psycho.core.domain.repositories.NoteRepository
import net.psycho.core.services.converters.note.NoteDto2EntityConverter
import net.psycho.core.services.converters.note.NoteEntity2DtoConverter
import net.psycho.core.services.dto.NoteDto

@RestController
class NoteController(private val noteDto2EntityConverter: NoteDto2EntityConverter,
                     private val noteEntity2DtoConverter: NoteEntity2DtoConverter,
                     private val noteRepository: NoteRepository) {

    @GetMapping("/notes")
    fun getNotes(): ResponseEntity<List<NoteDto?>> {
        return try {
            ResponseEntity(noteRepository.findAll().map(noteEntity2DtoConverter::convert), HttpStatus.OK)
        } catch (e: Exception) { ResponseEntity(HttpStatus.BAD_REQUEST) }
    }

    @PostMapping("/note")
    fun createNote(@RequestBody noteDto: NoteDto): ResponseEntity<String> {
        return try {
            noteRepository.save(noteDto2EntityConverter.convert(noteDto))
            ResponseEntity(HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/note/{id}")
    fun getNoteById(@PathVariable id: Long): ResponseEntity<NoteDto?> {
        return try {
            val noteDto = noteEntity2DtoConverter.convert(noteRepository.findByIdOrNull(id))
            if (noteDto != null) {
                ResponseEntity(noteDto, HttpStatus.OK)
            } else {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
        } catch (e: Exception) { ResponseEntity(HttpStatus.BAD_REQUEST) }
    }
}
