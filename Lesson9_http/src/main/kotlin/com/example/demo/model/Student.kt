package com.example.demo.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty


@ApiModel("Студент")
data class Student(
    @ApiModelProperty("идентификатор")
    var id: Int,
    @ApiModelProperty("идентификатор факультета")
    val facultyId: Int?,
    @ApiModelProperty("ФИО")
    val name: String,
    @ApiModelProperty("курс")
    val courseNumber: Int?,
)
