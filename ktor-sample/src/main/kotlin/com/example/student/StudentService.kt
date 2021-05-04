package com.example.student

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

class StudentService(
    private val database: Database,
    private val dao: StudentDao
) {
    fun findAll(): List<Student> = dao.findAll()

    fun findOne(id: Int) = transaction (database){ dao.findOne(id) }[0]

    fun create(name: String, groupId: Int): Student = transaction(database) {
        dao.create(name, groupId)
    }

    fun update(id: Int, name:String, groupId: Int) = transaction(database) {
        dao.update(id, name, groupId)
    }

    fun delete(id: Int) = transaction(database) {
        dao.delete(id)
    }

}