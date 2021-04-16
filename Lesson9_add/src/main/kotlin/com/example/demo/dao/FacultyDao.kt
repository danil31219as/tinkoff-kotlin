package com.example.demo.dao

import com.example.demo.model.Faculty
import org.springframework.stereotype.Repository

@Repository
class FacultyDao : AbstractFacultyDao {
    val data = mutableListOf(
        Faculty(1, "Math"),
        Faculty(2,  "Lang"),
    )

    override fun getFaculty(id: Int): List<Faculty> {
        return data.filter { it.id == id }
    }

    override fun getFaculty(): MutableList<Faculty> {
        return data
    }



}