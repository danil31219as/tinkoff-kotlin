package com.example.demo.models
import com.fasterxml.jackson.annotation.*
import java.time.LocalDate
import java.util.*



data class Category(
    val id: Long = 0L,
    val title: String = "",
    val description: String = "",

)
