package com.example.spring_data_jpa_lessons.repository

import com.example.spring_data_jpa_lessons.entity.Product
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
class ProductRepositoryTest(
    @Autowired
    private val productRepository: ProductRepository
) {

    @Test
    internal fun saveMethod() {
        val productTwo = Product()
        productTwo.sku = "300ABC"
        productTwo.name = "product 1"
        productTwo.description = "product 1 description"
        productTwo.price = BigDecimal(100)
        productTwo.imageUrl = "product 1 imageUrl"
        productTwo.active = true
        val saveObject = productRepository.save(productTwo)
        println(saveObject.id)
        println(productTwo)
    }

    @Test
    internal fun updateUsingSaveMethod() {
        val id = 1L
        val product = productRepository.findById(id).get()
        product.name = "updated product 1"
        product.description = "updated product 1 desc"
        productRepository.save(product)
    }

}