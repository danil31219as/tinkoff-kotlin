package com.example.group

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class GroupDao(private val database: Database) {
    fun findAll() = transaction(database) {
        Groups.selectAll().map(::extractStudent)
    }

    fun fildOne(id: Int) = transaction(database) {
        Groups.select{Groups.id eq id}.map(::extractStudent)
    }

    fun create(titleFac: String, number: Int): Group = transaction(database) {
        val id = Groups.insertAndGetId {
            it[Groups.titleFac] = titleFac
            it[Groups.number] = number
        }

        Group(id.value, titleFac, number)
    }

    fun update(id: Int, titleFac: String, number: Int): Int {
        Groups.update({ Groups.id eq id}){
            it[Groups.titleFac] = titleFac
            it[Groups.number] = number
        }
        return id
    }

    fun delete(id: Int): Int{
        Groups.deleteWhere{Groups.id eq id}
        return id
    }

    private fun extractStudent(row: ResultRow): Group = Group(
        row[Groups.id].value,
        row[Groups.titleFac],
        row[Groups.number]
    )
}