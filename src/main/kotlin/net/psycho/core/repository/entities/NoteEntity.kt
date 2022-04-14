package net.psycho.core.repository.entities

import org.hibernate.Hibernate
import javax.persistence.*

@Table(name = "notes")
@Entity
open class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long = 0
    @Column(name = "event", nullable = false)
    open var event: String = ""
    @Column(name = "emotion", nullable = false)
    open var emotion: String = ""
    @Column(name = "thought", nullable = false)
    open var thought: String = ""
    @Column(name = "action", nullable = false)
    open var action: String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as NoteEntity
        return id == other.id
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + event.hashCode()
        result = 31 * result + emotion.hashCode()
        result = 31 * result + thought.hashCode()
        result = 31 * result + action.hashCode()
        return result
    }

    override fun toString(): String {
        return this::class.simpleName + "(id=$id)"
    }
}
