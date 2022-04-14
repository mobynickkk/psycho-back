package net.psycho.core.repository.note

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

import net.psycho.core.repository.entities.NoteEntity

@Service
class NoteCrudServiceImpl(private val entityManager: EntityManager) : NoteCrudService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun createNote(note: NoteEntity?): NoteEntity? {
        logger.info("Creating entity {0}", note)
        entityManager.persist(note)
        return note
    }

    override fun readNote(id: Long): NoteEntity? {
        return entityManager.find(NoteEntity::class.java, id)
    }

    override fun readAllNotes(): List<NoteEntity> {
        // TODO: create query
        return entityManager.createQuery("").resultList.map { it as NoteEntity }
    }
}