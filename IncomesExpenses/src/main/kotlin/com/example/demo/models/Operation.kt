package com.example.demo.models

import com.fasterxml.jackson.annotation.*
import java.time.LocalDate
import java.util.*




data class Operation(
    val id: Long = 0L,
    val amount: Int = 0,
    val date: LocalDate = LocalDate.of(2021, 1, 1),
    val action: Int = 1,
    val categoryId: Int = 0,
    val way: String = "cash",
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