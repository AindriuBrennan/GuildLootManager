package controllers

import mu.KotlinLogging
import models.CharacterJSONStore
import models.CharacterModel
import tornadofx.*

class CharacterController: Controller() {

    val charModel = CharacterModel()
    val characters = CharacterJSONStore()
    val logger = KotlinLogging.logger {}


    init {
        logger.info { "Guild Loot Council Management App has launched!"}
    }

    fun addChar (_name: String, _race: String, _classType: String ) {
        var newChar = CharacterModel(name = _name, race = _race, classType = _classType)
        characters.create(newChar)
        logger.info("Character Added")
    }

    fun deleteChar (_name: String) {
       var charToDelete = CharacterModel(name = _name)
        characters.delete(charToDelete)
        logger.info("Character Deleted there ")
    }
}