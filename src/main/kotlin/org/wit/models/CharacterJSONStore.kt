package org.wit.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging


import org.wit.helpers.exists
import org.wit.helpers.read
import org.wit.helpers.write
import java.time.LocalDate
import java.util.*

private val logger = KotlinLogging.logger {}

val CHARACTER_JSON_FILE ="characters.json"
val characterGsonBuilder =GsonBuilder().setPrettyPrinting().create()
val characterListType = object : TypeToken<java.util.ArrayList<CharacterModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class CharacterJSONStore : CharacterStore {

    var characters = mutableListOf<CharacterModel>()

    init {
        if (exists(CHARACTER_JSON_FILE)) {
            deserialize()
        }
    }


    /**
     * Fine individual characters in the JSON file
     */

    override fun findOne(name: String): CharacterModel? {
        return characters.find { c -> c.name == name}
    }

    /**
     *
     * Find all characters in the JSON storage file
     *
     */

    override fun findAll(): MutableList<CharacterModel> {
        return characters
    }

    /**
     * Create a new character and generate a random ID for it
     *
     */

    override fun create(characterModel: CharacterModel) {
        characterModel.id = generateRandomId()
        characters.add(characterModel)
        serialize()
    }

    /**
     *
     * delete a character by name
     */

    override fun delete(name: String) {
        var charToDelete = findOne(name)
        if(charToDelete != null) {
            characters.remove(charToDelete)
        }
        serialize()
    }

    /**
     * Find the character that will have an item added to it and the date the character receieved the item
     *
     */

    override fun update(_name: String, _itemsCollected: Item, _dateCollected: LocalDate) {
        var foundCharacter = findOne(_name)
        if(foundCharacter != null) {
            foundCharacter.itemsCollected?.add(_itemsCollected)
            foundCharacter.dateCollected?.add(_dateCollected)
        }
        serialize()
    }

    /**
     * Delete an item previously awarded to a player, from the items collected list
     *
     */

    override  fun deleteItemFromPlayer(_name: String, _itemsCollected: Item, _dateCollected: LocalDate) {
        var foundCharacter = findOne(_name)
        if(foundCharacter != null) {
            foundCharacter.itemsCollected?.remove(_itemsCollected)
            foundCharacter.dateCollected?.remove(_dateCollected)
        }
        serialize()
    }

    internal fun logAll() {
        characters.forEach { logger.info("$it")}
    }

    private fun serialize() {
        val jsonString = characterGsonBuilder.toJson(characters, characterListType)
        write(CHARACTER_JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(CHARACTER_JSON_FILE)
        characters = Gson().fromJson(jsonString, characterListType)
    }

}