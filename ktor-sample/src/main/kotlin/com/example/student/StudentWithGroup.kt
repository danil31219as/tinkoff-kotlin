package com.example.student

import kotlinx.serialization.Serializable

@Serializable
data class StudentWithGroup (
    val id: Int,
    val name: String,
    val groupNumber: Int,
    val titleFac: String
)