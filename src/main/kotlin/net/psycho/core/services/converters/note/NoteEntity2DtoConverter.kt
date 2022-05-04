package net.psycho.core.services.converters.note

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

import net.psycho.core.domain.entities.NoteEntity
import net.psycho.core.services.dto.NoteDto

@Service
class NoteEntity2DtoConverter : Converter<NoteEntity, NoteDto> {

    override fun convert(source: NoteEntity?): NoteDto? {
        if (source == null) return null
        return NoteDto(source.id, source.event, source.emotion, source.thought, source.action)
    }
}