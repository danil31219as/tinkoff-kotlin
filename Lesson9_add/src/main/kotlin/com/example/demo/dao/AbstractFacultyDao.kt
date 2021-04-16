package com.example.demo.dao

import com.example.demo.model.Faculty

interface AbstractFacultyDao {
    fun getFaculty(id: Int): List<Faculty>
    fun getFaculty(): MutableList<Faculty>


}
