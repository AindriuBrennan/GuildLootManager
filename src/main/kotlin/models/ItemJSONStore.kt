package models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import helpers.*

private val logger = KotlinLogging.logger {}

val ITEM_JSON_FILE = "items.json"
val itemGsonBuilder = GsonBuilder().setPrettyPrinting().create()
val itemListType = object : TypeToken<java.util.ArrayList<Item>>() {}.type

class ItemJSONStore : ItemStore {

    var items = mutableListOf<Item>()

    init {
        if(exists(ITEM_JSON_FILE)){
            deserialize()
        }
    }

    override fun findOne(item: Item): Item? {
        return items.find { i -> i == item}
    }

    override fun findAll(): MutableList<Item>{
        return items
    }

    override fun update(item: Item, charactersWithItem: String) {
        val foundItem = findOne(item)
        if(foundItem != null) {
            foundItem.playersWithItem?.add(charactersWithItem)
        }
        serialize()
    }

    override fun delete(item: Item, charactersWithItem: String) {
        val foundItem = findOne(item)
        if(foundItem != null) {
            foundItem.playersWithItem?.remove(charactersWithItem)
        }
        serialize()
    }

    internal fun logAll() {
        items.forEach { logger.info("$it") }
    }

    private fun serialize() {
        val jsonString = itemGsonBuilder.toJson(items, itemListType)
        write(ITEM_JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(ITEM_JSON_FILE)
        items = Gson().fromJson(jsonString, itemListType)
    }
}
