package com.example.demo.service

import com.example.demo.models.Operation
import com.example.demo.repositories.OperationRepository
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.util.*

@Service
class OperationService(private val operationRepository: OperationRepository) {
    fun all(): Iterable<Operation> = operationRepository.findAll() // Возвращаем коллекцию сущностей, функциональная запись с указанием типа

    fun get(id: Long): Operation = operationRepository.findById(id)

    fun add(operation: Operation): Operation = operationRepository.save(operation)

    fun edit(id: Long, operation: Operation): Operation = operationRepository.update(id, operation)

    fun remove(id: Long) = operationRepository.deleteById(id)
}
