package helper

import model.animals.Cat
import model.caffe.Cafe
import model.caffe.Product
import model.caffe.Sponsorship
import model.people.Person
import model.shelter.Shelter

class CafeTestDataSource {

    private val catsInShelter1: MutableSet<Cat>
        get() {
            val cat1 = Cat(name = "Tiger", shelterId = shelter1.ID, gender = "male", sponsorships = mutableSetOf())
            val cat2 = Cat(name = "Missy", shelterId = shelter1.ID, gender = "female", sponsorships = mutableSetOf())
            return mutableSetOf(cat1, cat2)
        }

    private val catsInShelter2: MutableSet<Cat>
        get() {
            val cat3 = Cat(name = "Silvester", shelterId = shelter2.ID, gender = "male", sponsorships = mutableSetOf())
            val cat4 = Cat(name = "Garfield", shelterId = shelter2.ID, gender = "male", sponsorships = mutableSetOf())
            return mutableSetOf(cat3, cat4)
        }

    private val shelter1 = Shelter(name = "Kitten Care")
    private val shelter2 = Shelter(name = "The Cat House")


    fun getShelterInfo(): MutableSet<Shelter> = mutableSetOf(shelter1, shelter2)

    fun getShelterToCatInfo(): MutableMap<Shelter, MutableSet<Cat>> {
        var sheltersToCats = mutableMapOf<Shelter, MutableSet<Cat>>()
        sheltersToCats[shelter1] = catsInShelter1
        sheltersToCats[shelter2] = catsInShelter2
        return sheltersToCats
    }
}