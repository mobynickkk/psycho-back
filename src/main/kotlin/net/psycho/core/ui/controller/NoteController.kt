package net.psycho.core.ui.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import net.psycho.core.domain.repositories.NoteRepository
import net.psycho.core.domain.repositories.SchemaRepository
import net.psycho.core.services.converters.note.NoteDto2EntityConverter
import net.psycho.core.services.converters.note.NoteEntity2DtoConverter
import net.psycho.core.services.converters.schema.SchemaDto2EntityConverter
import net.psycho.core.services.converters.schema.SchemaEntity2DtoConverter
import net.psycho.core.services.dto.NoteDto
import net.psycho.core.services.dto.SchemaDto

@RestController
class NoteController(private val noteDto2EntityConverter: NoteDto2EntityConverter,
                     private val noteEntity2DtoConverter: NoteEntity2DtoConverter,
                     private val schemaDto2EntityConverter: SchemaDto2EntityConverter,
                     private val schemaEntity2DtoConverter: SchemaEntity2DtoConverter,
                     private val noteRepository: NoteRepository,
                     private val schemaRepository: SchemaRepository) {

    @GetMapping("/schemas")
    fun getSchemas(): ResponseEntity<List<SchemaDto>> {
        return try {
            val schemaEntities = schemaRepository.findAll()
            ResponseEntity(schemaEntities.map(schemaEntity2DtoConverter::convert), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/schema")
    fun createSchema(@RequestBody schemaDto: SchemaDto): ResponseEntity<String> {
        return try {
            schemaRepository.save(schemaDto2EntityConverter.convert(schemaDto))
            ResponseEntity(HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/notes")
    fun getNotes(): ResponseEntity<List<NoteDto>> {
        return try {
            val noteEntities = noteRepository.findAll()
            ResponseEntity(noteEntities.map(noteEntity2DtoConverter::convert), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
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
}
