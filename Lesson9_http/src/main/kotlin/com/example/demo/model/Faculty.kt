package com.example.demo.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("Факультет")
data class Faculty(
    @ApiModelProperty("идентификатор")
    val id: Int,
    @ApiModelProperty("название")
    val title: String,
)
