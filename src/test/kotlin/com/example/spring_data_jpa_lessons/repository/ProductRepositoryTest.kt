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
        val productOne = Product()
        productOne.sku = "100ABC"
        productOne.name = "product 1"
        productOne.description = "product 1 description"
        productOne.price = BigDecimal(100)
        productOne.imageUrl = "product 1 imageUrl"
        productOne.active = true
        val saveObject = productRepository.save(productOne)
        println(saveObject.id)
        println(productOne)
    }

    @Test
    internal fun updateUsingSaveMethod() {
        val id = 1L
        val product = productRepository.findById(id).get()
        product.name = "updated product 1"
        product.description = "updated product 1 desc"
        productRepository.save(product)
    }

    @Test
    internal fun findByIdMethod() {
        val id = 1L
        val product = productRepository.findById(id).get()
        println(product)
    }

    @Test
    internal fun saveAllMethod() {
        val productFour = Product()
        productFour.sku = "400ABC"
        productFour.name = "product 4"
        productFour.description = "product 4 description"
        productFour.price = BigDecimal(400)
        productFour.imageUrl = "product 4 imageUrl"
        productFour.active = true

        val productFive = Product()
        productFive.sku = "500ABC"
        productFive.name = "product 5"
        productFive.description = "product 5 description"
        productFive.price = BigDecimal(500)
        productFive.imageUrl = "product 5 imageUrl"
        productFive.active = true

        productRepository.saveAll(arrayListOf(productFour, productFive))

    }

}