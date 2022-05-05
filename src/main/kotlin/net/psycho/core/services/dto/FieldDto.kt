package net.psycho.core.services.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class FieldDto(@JsonProperty("name") val name: String,
                    @JsonProperty("value") val value: String)
