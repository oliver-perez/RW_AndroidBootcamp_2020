package model.caffe

import model.animals.Cat
import model.people.Person
import java.util.*

class Receipt(person: Person,
              products: List<Product>,
              discount: Double,
              adoptedCats: Set<Cat>?,
              sponsoredCats: Set<Cat>?,
              tip: Double) {

    val receiptID = UUID.randomUUID().toString()
    val clientName = person.firstName
    val clientEmail = person.email
    val createdAt: Date = Date()
    val products = products
    val discount = discount
    val adoptedCats = adoptedCats
    val sponsoredCats = sponsoredCats
    val tip: Double = tip

    val subTotal: Double
        get() {
            var sum: Double = 0.0
            for (product in products) {
                sum += if (product.category == ProductCategory.food || product.category == ProductCategory.drink)
                    product.price * (1 - discount / 100) else product.price
            }
            return sum
        }

    val total: Double
        get() {
            return subTotal + tip
        }
}