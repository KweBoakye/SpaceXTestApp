package com.kweboakye.spacextestapp.shared.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rocket(
    @SerialName("rocket_id")
    val id: String,
    @SerialName("rocket_name")
    val name: String,
    @SerialName("rocket_type")
    val type: String
)