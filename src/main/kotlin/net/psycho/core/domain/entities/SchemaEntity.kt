package net.psycho.core.domain.entities

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "schema")
class SchemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0
    @Column(name = "name", nullable = false)
    var name: String = ""
    @Column(name = "fields", nullable = false)
    var fields: String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as NoteEntity
        return id == other.id
    }

    override fun hashCode(): Int = 131073

    override fun toString(): String {
        return this::class.simpleName + "(id=$id)"
    }
}