package net.psycho.core.services.dto

data class SchemaDto(val id: Long,
                     val name: String,
                     val fieldsDescription: List<FieldDescrDto>)
