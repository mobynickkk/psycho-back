package net.psycho.core.services.converters.note

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

import net.psycho.core.domain.entities.NoteEntity
import net.psycho.core.domain.repositories.SchemaRepository
import net.psycho.core.services.dto.NoteDto
import org.springframework.data.repository.findByIdOrNull

@Service
class NoteDto2EntityConverter(private val schemaRepository: SchemaRepository)
    : Converter<NoteDto, NoteEntity> {

    private val objectWriter = ObjectMapper().writer()

    override fun convert(source: NoteDto): NoteEntity {
        val entity = NoteEntity()
        entity.id = source.id
        val schemaEntity = schemaRepository.findByIdOrNull(source.schemaId) ?: throw Exception("Bad schema")
        entity.schema = schemaEntity
        entity.fields = objectWriter.writeValueAsString(source.fieldsDto)
        return entity
    }
}
