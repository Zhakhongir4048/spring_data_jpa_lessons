package com.example.spring_data_jpa_lessons.repository

import com.example.spring_data_jpa_lessons.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime


interface ProductRepository : JpaRepository<Product, Long> {

    fun findByDateCreatedBetween(
        startDate: LocalDateTime,
        endDate: LocalDateTime
    ): List<Product>

}