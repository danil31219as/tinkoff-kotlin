package com.example.demo.models

import javax.persistence.*
import com.fasterxml.jackson.annotation.*
import java.time.LocalDate
import java.util.*

import javax.persistence.GenerationType

import javax.persistence.GeneratedValue




@Entity
data class Operation(
    @Id
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,
    @JsonProperty("amount")
    @Column(name = "amount")
    val amount: Int = 0,
    @JsonProperty("date")
    @Column(name = "date")
    val date: LocalDate = LocalDate.of(2021, 1, 1),
    @JsonProperty("action")
    @Column(name = "action")
    val action: Int = 1,
    @JsonProperty("categoryId")
    @Column(name = "categoryId")
    val categoryId: Int = 0,
    @JsonProperty("way")
    @Column(name = "way")
    val way: String = "cash",
    @JsonProperty("userId")
    @Column(name = "userId")
    val userId: Int = 0
    )
//@Entity
//class Person {
//    /**
//     * @return the id
//     */
//    /**
//     * @param id the id to set
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    var id: Int? = null
//    /**
//     * @return the name
//     */
//    /**
//     * @param name the name to set
//     */
//    var name: String? = null
//    /**
//     * @return the message
//     */
//    /**
//     * @param message the message to set
//     */
//    var message: String? = null
//}