package models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import helpers.*
import org.omg.CORBA.Object
import java.util.*

private val logger = KotlinLogging.logger {}

val CHARACTER_JSON_FILE ="characters.json"
val characterGsonBuilder =GsonBuilder().setPrettyPrinting().create()
val characterListType = object : TypeToken<java.util.ArrayList<Character>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class CharacterJSONStore : CharacterStore {

    var characters = mutableListOf<Character>()

    init {
        if (exists(CHARACTER_JSON_FILE)) {
            deserialize()
        }
    }

    override fun findOne(id: Long): Character? {
        return characters.find { c -> c.id == id}
    }

    override fun create(character: Character) {
        character.id = generateRandomId()
        characters.add(character)
        serialize()
    }

    override fun delete(character: Character) {
        characters.remove(character)
        serialize()
    }

    override fun update(character: Character) {
        var foundCharacter = findOne(character.id!!)
        if(foundCharacter != null) {
            foundCharacter.itemsCollected =character.itemsCollected
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