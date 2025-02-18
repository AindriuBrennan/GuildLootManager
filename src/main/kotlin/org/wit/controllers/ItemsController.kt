package org.wit.controllers

import org.wit.models.CharacterModel
import org.wit.models.Item
import org.wit.models.ItemJSONStore
import mu.KotlinLogging
import tornadofx.*

class ItemsController: Controller() {

    val itemModel = Item()
    val items = ItemJSONStore()
    val logger = KotlinLogging.logger {}


    init {
        logger.info { "Guild Loot Council Management App has launched!"}
    }

    fun updateItem(_itemName: Item, _playerWithItem: String)  {
        items.update(_itemName, _playerWithItem)
    }

    fun deletePlayerFromItem(_itemName: Item, _playerWithItem: String) {
        items.delete(_itemName, _playerWithItem)
    }

}