package com.example.student

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class StudentDao(private val database: Database) {
    fun findAll() = transaction(database) {
        Students.selectAll().map(::extractStudent)
    }

    fun findOne(id: Int) = Students.select { Students.id eq id }.map(::extractStudent)

    fun create(name: String, groupId: Int): Student = transaction(database) {
        val id = Students.insertAndGetId {
            it[Students.name] = name
            it[Students.groupId] = groupId
        }

        Student(id.value, name, groupId)
    }

    fun update(id: Int, name: String, groupId: Int): Int {
        Students.update({ Students.id eq id }) {
            it[Students.name] = name
            it[Students.groupId] = groupId
        }
        return id
    }

    fun delete(id: Int): Int {
        Students.deleteWhere { Students.id eq id }
        return id
    }

    private fun extractStudent(row: ResultRow): Student = Student(
        row[Students.id].value,
        row[Students.name],
        row[Students.groupId]
    )
}