package com.example.demo.dao

import com.example.demo.model.Student
import org.springframework.stereotype.Repository

@Repository
class StudentDao : AbstractStudentDao {
    val data = mutableListOf(
        Student(1, 2, "Peter Ivanov", 3),
        Student(2, 1, "Ivan Petrov", 1),
        Student(3, 1, "Vasiliy Smirnov", 4),
        Student(4, 2, "Vitaliy Kozlov", 2),
    )

    override fun getStudent(id: Int): List<Student> {
        return data.filter { it.id == id }
    }

    override fun getStudent(): MutableList<Student> {
        return data
    }

    override fun addStudent(student: Student) {
        if (data.filter { it.id == student.id }.isEmpty()) data.add(student)
    }

    override fun updateStudent(id: Int, student: Student): Student {
        data[id - 1] = Student(id = student.id,
            facultyId = student.facultyId ?: data[id].facultyId,
            name = student.name,
            courseNumber = student.courseNumber ?: data[id].courseNumber)
        return data[id - 1]
    }

    override fun deleteStudent(id: Int) {
        data[id - 1] = Student(0, name = "", facultyId = null, courseNumber = null)
    }

}