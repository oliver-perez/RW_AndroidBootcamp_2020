package model.caffe

import java.util.*

enum class ProductCategory {
    food, drink, other;
}

enum class MenuItem {
    coffe, cakeSlice, sandwich, catToy;
}

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val item: MenuItem,
    val price: Double,
    var category: ProductCategory
)
