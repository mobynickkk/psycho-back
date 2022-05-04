package net.psycho.core.domain.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import net.psycho.core.domain.entities.SchemaEntity

@Repository
interface SchemaRepository : CrudRepository<SchemaEntity, Long>
