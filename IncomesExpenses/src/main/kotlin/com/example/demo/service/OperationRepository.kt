package com.example.demo.service

import com.example.demo.models.Operation
import org.springframework.data.repository.*

interface OperationRepository : CrudRepository<Operation, Long> {
}