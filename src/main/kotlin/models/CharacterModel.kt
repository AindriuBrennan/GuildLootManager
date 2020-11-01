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
    var race: String = "",
    var classType: String = "",
    var itemsCollected: List<Item>? = emptyList(),
    var dateCollected: List<Date>? = emptyList(),
)



//figure this out

//val idProperty = SimpleLongProperty()
//var id  by idProperty
//val nameProperty = SimpleStringProperty()
//var name by nameProperty
//val raceProperty = SimpleStringProperty()
//var race by raceProperty
//val classTypeProperty = SimpleStringProperty()
//var classType by classTypeProperty
//var itemsCollected = FXCollections.observableArrayList<Item>()
//var dateCollected = FXCollections.observableArrayList<Date>()
//
//override fun updateModel(json: JsonObject) {
//    with(json) {
//        id = this.long("id")!!
//        name = string("name")
//        race = string("race")
//        classType = string("class")
//        itemsCollected.setAll(getJsonArray("itemsCollected").toModel())
//        dateCollected.setAll(getJsonArray("dateCollected").toModel())
//    }
//}
//
//fun toJson(json: JsonBuilder) {
//    with(json) {
//        add("id", id)
//        add("name", name)
//        add("race", race)
//        add("classType", classType)
//        add("itemsCollected", itemsCollected)
//        add("dateCollected", dateCollected)
//    }
//}