package com.example.demo.api

import com.example.demo.dao.FacultyComponent

import com.example.demo.model.Faculty

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/faculty")
class FacultyController(private val facultyDao: FacultyComponent) {

    @GetMapping("/{id}")
    fun getFaculty(@PathVariable id: Int): Faculty? {
        val response = facultyDao.getExampleFaculty(id)

        if (response.isNotEmpty()) {
            return response[0]
        } else {
            throw NotFoundException()
        }
    }

    @GetMapping()
    fun getFaculty() = facultyDao.getExampleFaculty()



}

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")
class NotFoundException : RuntimeException()