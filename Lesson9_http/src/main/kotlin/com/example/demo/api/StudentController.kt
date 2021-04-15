package com.example.demo.api

import com.example.demo.dao.StudentComponent

import com.example.demo.model.Student
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/st")
class StudentController(private val studentDao: StudentComponent) {

    @GetMapping()
    fun getStudent() = studentDao.getExampleStudent()

    @PostMapping
    fun addStudent(@RequestBody student: Student){

    }

}

