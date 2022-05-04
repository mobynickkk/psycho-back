package net.psycho.core.services.validation

import org.springframework.stereotype.Service

import net.psycho.core.domain.repositories.SchemaRepository
import net.psycho.core.services.converters.schema.SchemaEntity2DtoConverter
import net.psycho.core.services.dto.NoteDto

@Service
class NoteValidationServiceImpl(private val schemaRepository: SchemaRepository,
                                private val schemaEntity2DtoConverter: SchemaEntity2DtoConverter)
    : NoteValidationService {

    override fun validate(noteDto: NoteDto) {
        TODO("Not implemented different types and constraints")
    }
}