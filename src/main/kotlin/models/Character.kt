package models

import java.util.*

class Character (
     val name: String = "",
     val race: String = "",
     val classType: String = "",
     val itemsCollected: List<Item>,
)