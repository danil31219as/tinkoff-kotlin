package com.example.demo.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
@ApiModel("Студент + Факультет")
data class StudentWithFaculty(
    @ApiModelProperty("идентификатор")
    var id: Int,
    @ApiModelProperty("название факультета")
    val facultyName: String?,
    @ApiModelProperty("ФИО")
    val name: String,
    @ApiModelProperty("курс")
    val courseNumber: Int?,
)