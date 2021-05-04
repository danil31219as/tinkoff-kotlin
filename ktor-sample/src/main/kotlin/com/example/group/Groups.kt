package com.example.group

import org.jetbrains.exposed.dao.id.IntIdTable

object Groups : IntIdTable() {
    val titleFac = text("TITLEFAC")
    val number = integer("number")
}