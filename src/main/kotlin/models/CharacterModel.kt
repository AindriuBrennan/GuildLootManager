package models

import tornadofx.*
import java.time.LocalDate
import java.util.*
import javax.json.JsonObject

class CharacterModel(
        var id: Long? = 0,
        var name: String = "",
        var race: String? = "",
        var classType: String? = "",
        var itemsCollected: ArrayList<Item>? = ArrayList(),
        var dateCollected: ArrayList<LocalDate>? = ArrayList(),
)



