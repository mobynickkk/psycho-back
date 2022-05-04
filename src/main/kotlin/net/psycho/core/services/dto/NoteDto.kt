package net.psycho.core.services.dto

data class NoteDto(val id: Long,
                   val schemaId: Long,
                   val fieldsDto: List<FieldDto>)
