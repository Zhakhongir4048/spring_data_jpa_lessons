package com.example.spring_data_jpa_lessons.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
@Table(
    name = "product",
    schema = "ecommerce",
    uniqueConstraints = [
        UniqueConstraint(
            name = "sku_unique",
            columnNames = ["sku"]
        )
    ]
)
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(
        name = "product_generator",
        sequenceName = "product_sequence_name",
        allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    var id: Long? = null,
    @Column(name = "sku", nullable = false)
    var sku: String? = null,
    @Column(name = "name", nullable = false)
    var name: String? = null,
    @Column(name = "description", nullable = false)
    var description: String? = null,
    @Column(name = "price", nullable = false)
    var price: BigDecimal? = null,
    @Column(name = "active", nullable = false)
    var active: Boolean? = null,
    @Column(name = "imageUrl", nullable = false)
    var imageUrl: String? = null,
    @Column(name = "dateCreated", nullable = false)
    @CreationTimestamp
    var dateCreated: LocalDateTime? = null,
    @Column(name = "lastUpdated", nullable = false)
    @UpdateTimestamp
    var lastUpdated: LocalDateTime? = null
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(
                other
            )
        ) return false
        other as Product

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , sku = $sku , name = $name , description = $description , price = $price , active = $active , imageUrl = $imageUrl , dateCreated = $dateCreated , lastUpdated = $lastUpdated )"
    }

}