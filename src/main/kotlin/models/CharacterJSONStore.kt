package models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import helpers.*
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


    override fun findOne(name: String): CharacterModel? {
        return characters.find { c -> c.name == name}
    }

    override fun findAll(): MutableList<CharacterModel> {
        return characters
    }

    override fun create(characterModel: CharacterModel) {
        characterModel.id = generateRandomId()
        characters.add(characterModel)
        serialize()
    }

    override fun delete(characterModel: CharacterModel) {
        characters.remove(characterModel)
        serialize()
    }

    override fun update(characterModel: CharacterModel) {
        var foundCharacter = findOne(characterModel.name!!)
        if(foundCharacter != null) {
            foundCharacter.itemsCollected =characterModel.itemsCollected
        }
        serialize()
    }

    internal fun logAll() {
        characters.forEach {logger.info("$it")}
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