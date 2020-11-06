package controllers

import mu.KotlinLogging
import models.CharacterJSONStore
import models.CharacterModel
import models.Item
import tornadofx.*
import java.time.LocalDate

class CharacterController: Controller() {

    val charModel = CharacterModel()
    val characters = CharacterJSONStore()
    val logger = KotlinLogging.logger {}


    init {
        logger.info { "Guild Loot Council Management App has launched!"} }

    fun addChar (_name: String, _race: String, _classType: String ) {
        var newChar = CharacterModel(name = _name, race = _race, classType = _classType)
        characters.create(newChar)
        logger.info("Character Added")
    }


    fun deleteChar (_name: String) {
        characters.delete(_name)
        logger.info("Character Deleted there ")
    }

    fun deleteItemFromPlayer (_name: String, _itemsCollected: Item, _dateCollected: LocalDate) {
        characters.deleteItemFromPlayer(_name, _itemsCollected, _dateCollected)
    }



    fun updateChar(_name: String, _itemsCollected: Item, _dateCollected: LocalDate) {

        characters.update(_name, _itemsCollected, _dateCollected)
    }
}