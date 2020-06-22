package helper

import model.animals.Cat
import model.caffe.*
import model.people.Employee
import model.people.Person
import model.shelter.Shelter
import java.util.*

class CafeController {

    // cafe related things
    private val cafe = Cafe()
    private val shelters = cafe.shelters
    private val shelterToCat = cafe.shelterToCat

    fun adoptCat(catId: String, person: Person) {
        // check if cats exist, and retrieve its entry!

        val catInShelter = shelterToCat.entries.firstOrNull { (_, catsInShelter) ->
            catsInShelter.any {
                it.id == catId
            }
        }
        // you can adopt that cat!
        if (catInShelter != null) {
            val cat = catInShelter.value.first { cat -> cat.id == catId } // find the cat for that ID again

            // remove the cat from the shelter
            catInShelter.value.remove(cat)

            // add the cat to the person
            person.cats.add(cat)
            cafe.registerCustomer(person)
        }
    }

    fun sponsorCat(catId: String, person: Person) {
        // check if cats exist, and retrieve its entry!

        val catInShelter = shelterToCat.entries.firstOrNull { (_, catsInShelter) ->
            catsInShelter.any {
                it.id == catId
            }
        }
        // you can sponsor that cat!
        if (catInShelter != null) {
            val cat = catInShelter.value.first { cat -> cat.id == catId } // find the cat for that ID again

            // add the sponsorship to the cat
            cat.sponsorships.add(Sponsorship(patronId = person.id, catId = catId))
            cafe.registerCustomer(person)
        }
    }

    fun sellItems(items: List<Product>, customerId: String, tip: Double) {
        val receipt = cafe.getReceipt(items, customerId, tip)
        printReceipt(receipt)
    }

    fun getNumberOfTransactions(day: String): Int = cafe.showNumberOfReceiptsForDay(day)

    private fun printReceipt(receipt: Receipt) {
        println("---------------------------------------------------------------")
        println("-----------------Pawffee Cat Cafe Receipt-----------------------")
        println("---------------${receipt.createdAt}---------------------")
        println("   Client name: ${receipt.clientName}")
        println("   client email: ${receipt.clientEmail}")
        println("   Products: ${receipt.products.map { "${it.item.name}: $${it.price}" } }")
        println("   Adopted Cats: ${receipt.adoptedCats?.map { "Name: ${it.name} ID: ${it.id}" } }")
        println("   Sponsored Cats: ${receipt.sponsoredCats?.map { "Name: ${it.name} ID: ${it.id}" } }")
        if (receipt.discount > 0) {
            println("   Products with discount: " +
                    "${receipt.products
                            .filter { it.category == ProductCategory.food || it.category == ProductCategory.drink }
                            .map { "${it.item.name}: ${receipt.discount}%" } }")
        }
        println("   Subtotal: $${receipt.subTotal}")
        println("   Tip: $${receipt.tip}")
        println("  -----------------")
        println("    Total: $${receipt.total}")
        println("---------------------------------------------------------------")
    }

    fun getNumberOfAdoptionsPerShelter(): Map<String, Int> {
        val allAdopters = cafe.getAdopters()
        val adoptedCats: List<Cat> = allAdopters.flatMap { it.cats }
        val adoptionsPerShelter = mutableMapOf<String, Int>()
        for (shelter in shelters) {
            adoptionsPerShelter[shelter.name] = adoptedCats.filter { it.shelterId == shelter.ID }.count()
        }
        return adoptionsPerShelter
    }

    fun getUnadoptedUnsponsoredCats(): Set<Cat> = shelterToCat
            .flatMap { it.value }
            .filter { it.sponsorships.isEmpty() }
            .toSet()

    fun getSponsoredUnadoptedCats(): Set<Cat> = shelterToCat
            .flatMap { it.value }
            .filter { it.sponsorships.isNotEmpty() }
            .toSet()

    fun getMostPopularCats(): Set<Cat> = shelterToCat
            .flatMap { it.value }
            .filter { it.sponsorships.isNotEmpty() }
            .sortedByDescending { it.sponsorships.count() }
            .toSet()

    fun getTopThreeSellingItems(): List<Pair<MenuItem, Int>> = cafe
            .getTopSellingItems()
            .take(3)

    fun getNumberOfNonEmployeePatrons(): Int = cafe
            .getCustomers()
            .filter { it !is Employee }
            .count()

    fun getAdoptedCats(): Set<Cat> = cafe.getAdoptedCats()

    fun getNumberOfCustomers(): Int = cafe.getCustomers().count()

    fun getCatIDs(): List<String> = shelterToCat
            .flatMap { it.value }
            .map { it.id }
}