package com.example.group

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.transactions.transaction

class GroupService(
    private val database: Database,
    private val dao: GroupDao
) {
    fun findAll(): List<Group> = dao.findAll()

    fun findOne(id: Int): Group = dao.fildOne(id).first()

    fun create(titleFac: String, number: Int): Group = transaction(database) {
        dao.create(titleFac, number)
    }

    fun update(id: Int, titleFac: String, number: Int) = transaction(database) {
        dao.update(id, titleFac, number)
    }

    fun delete(id: Int) = transaction(database) {
        dao.delete(id)
    }

}