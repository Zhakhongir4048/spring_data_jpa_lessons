package com.example.spring_data_jpa_lessons.repository

import com.example.spring_data_jpa_lessons.SpringDataJpaLessonsApplication
import com.example.spring_data_jpa_lessons.entity.Product
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest(classes = [SpringDataJpaLessonsApplication::class])
class ProductRepositoryTest(
    @Autowired
    private val productRepository: ProductRepository
) {

    @Test
    internal fun saveMethod() {
        val productTwo = Product()
        productTwo.sku = "100ABC"
        productTwo.name = "product 1"
        productTwo.description = "product 1 description"
        productTwo.price = BigDecimal(100)
        productTwo.imageUrl = "product 1 imageUrl"
        productTwo.active = true
        val saveObject = productRepository.save(productTwo)
        println(saveObject.id)
        println(productTwo)
    }

}