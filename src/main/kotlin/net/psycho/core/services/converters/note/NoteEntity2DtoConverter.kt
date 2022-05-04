package net.psycho.core.services.converters.note

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

import net.psycho.core.domain.entities.NoteEntity
import net.psycho.core.services.dto.FieldDto
import net.psycho.core.services.dto.NoteDto

@Service
class NoteEntity2DtoConverter : Converter<NoteEntity, NoteDto> {
    private val objectMapper = ObjectMapper()

    override fun convert(source: NoteEntity): NoteDto {
        val javaType = objectMapper.typeFactory.constructCollectionType(List::class.java, FieldDto::class.java)
        return NoteDto(source.id, source.schema.id, objectMapper.readValue(source.fields, javaType))
    }
}