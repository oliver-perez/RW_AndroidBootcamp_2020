package model.shelter

import model.animals.Cat
import model.caffe.Sponsorship
import java.util.*

// TODO add remaining data
data class Shelter(
        val ID: String = UUID.randomUUID().toString(),
        val name: String
)