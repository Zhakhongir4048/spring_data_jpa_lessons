package com.example.spring_data_jpa_lessons.service

import com.example.spring_data_jpa_lessons.entity.Product
import java.util.*


interface ProductService {

    fun saveProduct(): Optional<Product>

    fun delete()

}