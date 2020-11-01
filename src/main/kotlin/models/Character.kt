package models

import java.util.*

class Character (
    var id: Long? =0,
    val name: String = "",
    val race: String = "",
    val classType: String = "",
    var itemsCollected: List<Item>,
)