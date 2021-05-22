package com.example.group

import kotlinx.serialization.Serializable

@Serializable
data class Group(
    val id: Int,
    val titleFac: String,
    val number: Int,
)