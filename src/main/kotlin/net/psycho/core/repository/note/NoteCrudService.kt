package net.psycho.core.repository.note

import net.psycho.core.repository.entities.NoteEntity

sealed interface NoteCrudService {
    fun createNote(note: NoteEntity?): NoteEntity?

    fun readNote(id: Long): NoteEntity?

    fun readAllNotes(): List<NoteEntity>
}
