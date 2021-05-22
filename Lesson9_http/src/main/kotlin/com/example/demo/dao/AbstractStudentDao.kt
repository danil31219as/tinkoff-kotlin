package com.example.demo.dao

import com.example.demo.model.Student
import org.springframework.stereotype.Repository
interface AbstractStudentDao {
    fun getStudent(id: Int): List<Student>
    fun getStudent(): MutableList<Student>
    fun addStudent(student: Student)
    fun updateStudent(id: Int, student: Student): Student
    fun deleteStudent(id: Int)

}
