package net.psycho.core.services.converters.schema

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

import net.psycho.core.domain.entities.SchemaEntity
import net.psycho.core.services.dto.SchemaDto

@Service
class SchemaDto2EntityConverter : Converter<SchemaDto, SchemaEntity> {

    private val objectWriter = ObjectMapper().writer()

    override fun convert(source: SchemaDto): SchemaEntity {
        val entity = SchemaEntity()
        entity.id = source.id
        entity.name = source.name
        entity.fields = objectWriter.writeValueAsString(source.fieldsDescription)
        return entity
    }
}
