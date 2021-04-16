package com.example.demo.api

import com.example.demo.dao.StudentComponent
import com.example.demo.model.Faculty

import com.example.demo.model.Student
import com.example.demo.model.StudentWithFaculty
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import com.google.gson.*
import io.swagger.annotations.ApiOperation

@RestController
@RequestMapping("/student")
class StudentController(private val studentDao: StudentComponent) {
    @ApiOperation(value = "Получение студента по его id",
        notes = "Позволяет получить сущность студента с именнованным факультетом по его id")
    @GetMapping("/{id}")
    fun getStudent(@PathVariable id: Int): StudentWithFaculty {

        val response = studentDao.getExampleStudent(id)

        if (response.isNotEmpty()) {
            val gson = Gson()
            val client = HttpClient.newBuilder().build();
            val request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:5000/faculty/${response[0].facultyId}"))
                .build();

            val result =
                client.send(request, HttpResponse.BodyHandlers.ofString());
            val faculty: Faculty =
                gson.fromJson(result.body(), Faculty::class.java)
            return StudentWithFaculty(response[0].id,
                faculty.title,
                response[0].name,
                response[0].courseNumber)
        } else {
            throw NotFoundException()
        }
    }

    @ApiOperation("Получение списка всех студентов",
        notes = "Возвращает все существующие сущности студентов")
    @GetMapping()
    fun getStudent() = studentDao.getExampleStudent()

    @ApiOperation("Добавление студента",
        notes = "Добавляет студента по его сущности")
    @PostMapping
    fun addStudent(@RequestBody student: Student): String {
        studentDao.addExampleStudent(student)
        return "Student ${student.name} was added"
    }

    @ApiOperation("Изменение студента",
        notes = "Изменение параметров сущности студента с некоторым id на полученные в новой сущности параметры")
    @PutMapping("/{id}")
    fun updateStudent(
        @PathVariable id: Int,
        @RequestBody student: Student,
    ): String? {
        val response = studentDao.getExampleStudent(id)

        if (response.isNotEmpty()) {
            return "Update student ${
                studentDao.updateExampleStudent(id,
                    student)
            }"
        } else {
            throw NotFoundException()
        }
    }

    @ApiOperation("Удаление студента",
        notes = "Удаляет сущность студента с некоторым id")
    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Int): String? {
        val response = studentDao.getExampleStudent(id)

        if (response.isNotEmpty()) {
            studentDao.deleteExampleStudent(id)
            return "Delete student ${response[0]}"
        } else {
            throw NotFoundException()
        }
    }

}

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")
class NotFoundException : RuntimeException()