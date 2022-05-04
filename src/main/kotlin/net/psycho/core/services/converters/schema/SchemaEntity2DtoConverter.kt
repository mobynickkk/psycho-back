package net.psycho.core.services.converters.schema

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

import net.psycho.core.domain.entities.SchemaEntity
import net.psycho.core.services.dto.FieldDescrDto
import net.psycho.core.services.dto.SchemaDto

@Service
class SchemaEntity2DtoConverter : Converter<SchemaEntity, SchemaDto> {
    private val objectMapper = ObjectMapper()

    override fun convert(source: SchemaEntity): SchemaDto {
        val javaType = objectMapper.typeFactory.constructCollectionType(List::class.java, FieldDescrDto::class.java)
        return SchemaDto(source.id, source.name, objectMapper.readValue(source.fields, javaType))
    }
}
