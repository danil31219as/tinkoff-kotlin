package com.example.student

import org.jetbrains.exposed.dao.id.IntIdTable

object Students : IntIdTable() {
    val name = text("name")
    val groupId = integer("GROUPID")
}