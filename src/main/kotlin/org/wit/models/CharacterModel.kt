package org.wit.models


import java.time.LocalDate
import java.util.*

/**
 * Character model for users to create
 */

class CharacterModel(
        var id: Long? = 0,
        var name: String = "",
        var race: String? = "",
        var classType: String? = "",
        var itemsCollected: ArrayList<Item>? = ArrayList(),
        var dateCollected: ArrayList<LocalDate>? = ArrayList(),
)



