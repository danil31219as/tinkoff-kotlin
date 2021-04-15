package com.example.demo.dao

import org.springframework.stereotype.Service

@Service
class StudentComponent(private val dao: StudentDao) {
    fun getExampleStudent(id: Int) = dao.getStudent(id)
    fun getExampleStudent() = dao.getStudent()
}