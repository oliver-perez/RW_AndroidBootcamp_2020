package model.caffe

import helper.CafeTestDataSource
import model.animals.Cat
import model.people.Employee
import model.people.Person
import java.util.*

class Cafe {

    private val dataSource = CafeTestDataSource()
    val shelters = dataSource.getShelterInfo()
    val shelterToCat = dataSource.getShelterToCatInfo()

    private val receiptsByDay = mutableMapOf(
            "Monday" to mutableSetOf<Receipt>(),
            "Tuesday" to mutableSetOf<Receipt>(),
            "Wednesday" to mutableSetOf<Receipt>(),
            "Thursday" to mutableSetOf<Receipt>(),
            "Friday" to mutableSetOf<Receipt>(),
            "Saturday" to mutableSetOf<Receipt>(),
            "Sunday" to mutableSetOf<Receipt>()
    )

    private val employees = mutableSetOf<Employee>()
    private val customers = mutableSetOf<Person>()

    // make sure to add sponsorships and tie them to people!
    private val sponsorships = mutableSetOf<Sponsorship>()

    // TODO Add logic for checking in and checking out!
    fun checkInEmployee(employee: Employee) {

    }

    fun checkOutEmployee(employee: Employee) {

    }

    fun registerCustomer(customer: Person) {
        customers.add(customer)
    }

    fun showNumberOfReceiptsForDay(day: String): Int = receiptsByDay[day]?.count() ?: 0

    fun getReceipt(items: List<Product>, customerId: String, tip: Double): Receipt {
        val customer = (employees + customers).first { it.id == customerId }
        val discount = if (customer is Employee) 15.0 else 0.0

        val receipt = Receipt(person = customer,
                products = items,
                discount = discount,
                adoptedCats = getAdoptedCats(customerId),
                sponsoredCats = getSponsoredCats(customerId),
                tip = tip)

        // "Hardcoded day fot testing purpose
        val day = "Monday"
        receiptsByDay[day]?.add(receipt)

        return receipt
    }

    fun getNumberOfTransactions(day: String): Int = receiptsByDay[day]?.count() ?: 0


    fun getAdoptedCats(): Set<Cat> = (customers + employees)
            .flatMap { it.cats }
            .toSet()

    private fun getAdoptedCats(customerId: String): Set<Cat> = (customers + employees)
            .filter { it.id == customerId }
            .flatMap { it.cats }.toSet()

    private fun getSponsoredCats(customerId: String): Set<Cat> = shelterToCat
            .flatMap { it.value }
            .filter { cat -> cat.sponsorships
                        .map { it.patronId }
                        .contains(customerId) }
            .toSet()

    fun getTopSellingItems(): Set<Pair<MenuItem, Int>> {
        var counts: MutableMap<MenuItem, Int> = mutableMapOf()
        for (item in MenuItem.values()) { counts[item] = 0 }

        receiptsByDay
                .flatMap { it.value }
                .flatMap { receipt -> receipt.products.map { it.item } }
                .forEach { counts[it] = (counts[it]?: 0) + 1 }

        return counts
                .map { Pair(it.key, it.value) }
                .sortedByDescending { it.second }
                .map { Pair(it.first, it.second) }
                .toSet()
    }

    fun getAdopters(): List<Person> = (employees + customers)
            .filter { it.cats.isNotEmpty() }


    fun getCustomers(): MutableSet<Person> = customers
}