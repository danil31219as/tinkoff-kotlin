package com.example.demo.system

import org.springframework.data.repository.*

interface ProductRepository : CrudRepository<Product, Long>