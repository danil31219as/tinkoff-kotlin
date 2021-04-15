package com.example.demo.dao

import com.example.demo.model.Student
import org.springframework.stereotype.Repository

@Repository
class StudentDao: AbstractStudentDao {
    val data = listOf(
        Student(1, 2, "Peter Ivanov", 3),
        Student(2, 1, "Ivan Petrov", 1),
        Student(3, 1, "Vasiliy Smirnov", 4),
        Student(4, 2, "Vitaliy Kozlov", 2),
    )

    override fun getStudent(id: Int): Student {
        return data.filter{it.id == id}[0]
    }
    override fun getStudent(): List<Student>{
        return data
    }
}