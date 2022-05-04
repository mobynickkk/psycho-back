package net.psycho.core.domain.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import net.psycho.core.domain.entities.NoteEntity

@Repository
interface NoteRepository : CrudRepository<NoteEntity, Long> {
    fun findAllBySchemaId(id: Long): Iterable<NoteEntity>
}
