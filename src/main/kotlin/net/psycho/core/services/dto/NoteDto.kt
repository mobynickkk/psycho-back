package net.psycho.core.services.dto

/**
 * DTO for notes about psych. state
 */
data class NoteDto(val id: Long,
                   val event: String,
                   val emotion: String,
                   val thought: String,
                   val action: String)
