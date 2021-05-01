package com.example.demo.models
import javax.persistence.*
import com.fasterxml.jackson.annotation.*
import java.time.LocalDate
import java.util.*

import javax.persistence.GenerationType

import javax.persistence.GeneratedValue




@Entity
data class Category(
    @Id
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,
    @JsonProperty("title")
    @Column(name = "title")
    val title: String = "",
    @JsonProperty("description")
    @Column(name = "description")
    val description: String = "",

)
