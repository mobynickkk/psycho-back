package net.psycho.core.services.converters.note

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

import net.psycho.core.repository.entities.NoteEntity
import net.psycho.core.services.dto.NoteDto

@Service
class NoteDto2EntityConverter : Converter<NoteDto, NoteEntity> {

    override fun convert(source: NoteDto?): NoteEntity? {
        if (source == null) return null

        val entity = NoteEntity()
        entity.id = source.id
        entity.emotion = source.emotion
        entity.event = source.event
        entity.thought = source.thought
        entity.action = source.action
        return entity
    }
}
