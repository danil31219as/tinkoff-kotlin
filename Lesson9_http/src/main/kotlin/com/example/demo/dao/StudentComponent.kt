package com.example.demo.dao

import com.example.demo.model.Student
import org.springframework.stereotype.Service

@Service
class StudentComponent(private val dao: StudentDao) {
    fun getExampleStudent(id: Int) = dao.getStudent(id)
    fun getExampleStudent() = dao.getStudent()
    fun addExampleStudent(student: Student) {
        dao.addStudent(student)
    }

    fun updateExampleStudent(id: Int, student: Student) =
        dao.updateStudent(id, student)

    fun deleteExampleStudent(id: Int){
        dao.deleteStudent(id)
    }
}