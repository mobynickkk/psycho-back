package net.psycho.core.domain.entities

import org.hibernate.Hibernate
import javax.persistence.*

@Table(name = "notes")
@Entity
class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0
    @Column(name = "event", nullable = false)
    var event: String = ""
    @Column(name = "emotion", nullable = false)
    var emotion: String = ""
    @Column(name = "thought", nullable = false)
    var thought: String = ""
    @Column(name = "action", nullable = false)
    var action: String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as NoteEntity
        return id == other.id
    }

    override fun hashCode(): Int = 131071

    override fun toString(): String {
        return this::class.simpleName + "(id=$id)"
    }
}
