package net.psycho.core.services.validation

import net.psycho.core.services.dto.NoteDto

interface NoteValidationService {
    fun validate(noteDto: NoteDto)
}
