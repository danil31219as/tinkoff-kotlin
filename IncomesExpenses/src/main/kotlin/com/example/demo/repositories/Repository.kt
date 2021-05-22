package com.example.demo.repositories

interface Repository<Model, Type> {
    fun findById(id: Type): Model
    fun findAll(): MutableList<Model>
    fun save(model: Model): Model
    fun update(id: Type, model: Model): Model
    fun deleteById(id: Type): Type


}