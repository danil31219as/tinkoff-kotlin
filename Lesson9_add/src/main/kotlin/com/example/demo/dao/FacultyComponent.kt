package com.example.demo.dao

import org.springframework.stereotype.Service

@Service
class FacultyComponent(private val dao: FacultyDao) {
    fun getExampleFaculty(id: Int) = dao.getFaculty(id)
    fun getExampleFaculty() = dao.getFaculty()

}