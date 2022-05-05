package net.psycho.core.services.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class FieldDescrDto(@JsonProperty("name") val name: String,
                         @JsonProperty("type") val type: String)
