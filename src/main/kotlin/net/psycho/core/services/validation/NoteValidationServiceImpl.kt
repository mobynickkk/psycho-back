package net.psycho.core.services.validation

import net.psycho.core.domain.repositories.SchemaRepository
import net.psycho.core.services.converters.schema.SchemaEntity2DtoConverter
import net.psycho.core.services.dto.NoteDto
import org.springframework.stereotype.Service

@Service
class NoteValidationServiceImpl(private val schemaRepository: SchemaRepository,
                                private val schemaEntity2DtoConverter: SchemaEntity2DtoConverter)
    : NoteValidationService {

    override fun validate(noteDto: NoteDto) {
        TODO("Not implemented different types and constraints")
    }
}