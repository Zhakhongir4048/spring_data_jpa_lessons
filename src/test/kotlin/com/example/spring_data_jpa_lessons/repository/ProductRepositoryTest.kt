package com.example.spring_data_jpa_lessons.repository

import com.example.spring_data_jpa_lessons.entity.Product
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.math.BigDecimal

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ProductRepositoryTest(
    @Autowired
    private val productRepository: ProductRepository
) {

    @Test
    internal fun saveMethod() {
        val productOne = Product(
            1,
            "100ABC",
            "product 1",
            "product 1 description",
            BigDecimal(100),
            true,
            "product 1 imageUrl"
        )
        productRepository.save(productOne)
        println(productOne.id)
        println(productOne)
    }

}