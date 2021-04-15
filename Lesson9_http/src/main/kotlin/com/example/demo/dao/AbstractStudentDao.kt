package com.example.demo.dao

import com.example.demo.model.Student
import org.springframework.stereotype.Repository
interface AbstractStudentDao {
    fun getStudent(id: Int): Student
    fun getStudent(): List<Student>

}
