package models

import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*
import java.util.*
import javax.json.JsonObject

class CharacterModel (
    var id: Long? = 0,
    var name: String = "",
    var race: String? = "",
    var classType: String? = "",
    var itemsCollected: List<Item>? = emptyList(),
    var dateCollected: List<Date>? = emptyList(),
)



