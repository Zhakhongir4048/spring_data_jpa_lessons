package com.example.spring_data_jpa_lessons.repository

import com.example.spring_data_jpa_lessons.entity.Product
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Sort
import java.math.BigDecimal
import java.time.LocalDateTime

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

    @Test
    internal fun findAllMethod() {
        val mutableList = productRepository.findAll()
        mutableList.forEach { product -> println(product.name) }
    }

    @Test
    internal fun deleteByIdMethod() {
        val id = 1L
        productRepository.deleteById(id)
    }

    @Test
    internal fun deleteMethod() {
        val id = 2L
        val findByIdProduct = productRepository.findById(id).get()
        productRepository.delete(findByIdProduct)
    }

    @Test
    internal fun deleteAllMethod() {
        productRepository.deleteAll()
    }

    @Test
    internal fun deleteAllMethod2() {
        val productId5 = productRepository.findById(5L).get()
        val productId6 = productRepository.findById(6L).get()
        productRepository.deleteAll(arrayListOf(productId5, productId6))
    }

    @Test
    internal fun countMethod() {
        println(productRepository.count())
    }

    @Test
    internal fun existsByIdMethod() {
        println(productRepository.existsById(100L))
    }

    @Test
    internal fun findByDateCreatedBetweenMethod() {
        val list = productRepository.findByDateCreatedBetween(
            LocalDateTime.of(2023, 3, 12, 18, 29, 40),
            LocalDateTime.of(2023, 3, 12, 18, 29, 53)
        )
        list.forEach { product ->
            println(product.id)
            println(product.name)
        }
    }

    @Test
    internal fun sortingByMultipleFields() {
        val sortBy = "name"
        val sortByDesc = "description"
        val sortDir = "desc"
        val sortByName =
            if (sortDir.equals(Sort.Direction.ASC.name, ignoreCase = true))
                Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()

        val sortByDescription =
            if (sortDir.equals(Sort.Direction.ASC.name, ignoreCase = true))
                Sort.by(sortByDesc).ascending() else Sort.by(sortByDesc).descending()

        val groupBySort = sortByName.and(sortByDescription)
        val list = productRepository.findAll(groupBySort)
        list.forEach { product -> println(product) }
    }

}