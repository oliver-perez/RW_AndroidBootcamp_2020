import helper.CafeController
import model.caffe.MenuItem
import model.caffe.Product
import model.caffe.ProductCategory
import model.people.Employee
import model.people.Patron

fun main() {

  // Given
    val cafeController = CafeController() // print out the data here using CafeController functions
    val catIDs = cafeController.getCatIDs()
    val Oliver = Patron(firstName = "Oliver", lastName = "Perez", email = "oliverperez.e@gmail.com", phoneNumber = "123456789")
    val John = Patron(firstName = "John", lastName = "Doe", email = "john.doe@mail.com", phoneNumber = "098754321")
    val Ana = Employee(firstName = "Ana", lastName = "Karenina", email = "ana.karenina@mail.com", phoneNumber = "000111222", salary = 1000.0, socialSecurityNumber = "000111222333", hireDate = "01/01/2020")

    val catID1 = catIDs[0] // Tiger
    val catID2 = catIDs[1] // Missy
    val catID3 = catIDs[2] // Silvester
    val catID4 = catIDs[2] // Garfield

    // When

    // Oliver adopts a cat
    cafeController.adoptCat(catId = catID1, person = Oliver)

    // Everyone sponsors a cat
    cafeController.sponsorCat(catId = catID3, person = Oliver)
    cafeController.sponsorCat(catId = catID3, person = John)
    cafeController.sponsorCat(catId = catID2, person = Ana)
    cafeController.sponsorCat(catId = catID3, person = Ana)

    // Oliver (simple customer) buys a coffee
    val itemsForOliver = listOf<Product>(
            Product(price = 1.0, item = MenuItem.coffe, category = ProductCategory.drink),
            Product(price = 1.0, item = MenuItem.catToy, category = ProductCategory.other))
    cafeController.sellItems(items = itemsForOliver, customerId = Oliver.id, tip = 1.0)

    // Ana (employee) buys a cake slice and a tea
    val itemsForAna = listOf<Product>(
            Product(price = 3.0, item = MenuItem.cakeSlice, category = ProductCategory.food),
            Product(price = 1.0, item = MenuItem.catToy, category = ProductCategory.other))
    cafeController.sellItems(items = itemsForAna, customerId = Ana.id, tip = 1.5)

    // Then
    // 1) Number of transactions (receipts) for that business day
    println("1) Number of transactions on Monday: " + cafeController.getNumberOfTransactions(day = "Monday"))

    // 2) total number of customers (both employees who bought stuff and regular patrons for the day
    println("2) Total number of customers: " + cafeController.getNumberOfCustomers())

    // 3) Total number of non-employee patrons for the day
    println("3) Total number of non-employee patrons for the day: " + cafeController.getNumberOfNonEmployeePatrons())

    // 4) Total number of non-employee patrons for the day
    println("3) Total number of non-employee patrons for the day: " + cafeController.getNumberOfNonEmployeePatrons())

    // 5) Total number of adoptions, per shelter:
    println("5) Number of adoptions per shelter: " + cafeController.getNumberOfAdoptionsPerShelter())

    // 6) List of the unadopted, unsponsored cats staying at the cafe currently
    println("6) Unadopted, unsponsored cat names: " + cafeController.getUnadoptedUnsponsoredCats().map { it.name } )

    // 7) List of the sponsored, unadopted cats staying at the cafe
    println("7) Sponsored, unadopted cat names: " + cafeController.getSponsoredUnadoptedCats().map { it.name } )

    // 8) Top three selling menu items for that day
    println("9) Most popular menu items: " + cafeController.getTopThreeSellingItems() )

    // 9) List of the most popular cats, in order of rank (popularity is judged based on number of sponsorships
    println("9) Most popular cats: " + cafeController.getMostPopularCats().map { it.name } )

}