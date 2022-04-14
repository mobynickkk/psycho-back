package net.psycho.core.ui.controller

import net.psycho.core.repository.note.NoteCrudService
import net.psycho.core.services.converters.note.NoteDto2EntityConverter
import net.psycho.core.services.converters.note.NoteEntity2DtoConverter
import net.psycho.core.services.dto.NoteDto
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(value = ["/notes"])
class NoteController(private val noteDto2EntityConverter: NoteDto2EntityConverter,
                     private val noteEntity2DtoConverter: NoteEntity2DtoConverter,
                     private val noteCrudService: NoteCrudService) {

    @GetMapping
    fun getNotes(): List<NoteDto?> {
        return noteCrudService.readAllNotes().map(noteEntity2DtoConverter::convert)
    }

    @PostMapping
    fun createNote(noteDto: NoteDto) {
        noteCrudService.createNote(noteDto2EntityConverter.convert(noteDto))
    }

    @GetMapping
    fun getNoteById(id: Long): NoteDto? {
        return noteEntity2DtoConverter.convert(noteCrudService.readNote(id))
    }
}