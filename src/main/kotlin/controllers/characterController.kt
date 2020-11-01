package controllers

import mu.KotlinLogging
import models.CharacterJSONStore
import models.CharacterModel
import tornadofx.*

class characterController: Controller() {

    val characters = CharacterJSONStore()
    val logger = KotlinLogging.logger {}


    init {
        logger.info { "Guild Loot Council Management App has launched!"}
    }

    fun addChar (_name: String, _race: String, _classType: String ) {
        var newChar = CharacterModel(name = _name, race = _race, classType = _classType)
        characters.create(newChar)
        logger.info("Character added")
    }

//    fun deleteChar (_name: String,_race: String,_classType: String) {
//        var findChar =
//        characters.remove()
//
//        }
//
//    }

}