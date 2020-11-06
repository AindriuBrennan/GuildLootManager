package org.wit.models

import java.time.LocalDate

interface CharacterStore {
    fun findOne(name: String): CharacterModel?
    fun findAll(): List<CharacterModel>
    fun create(characterModel: CharacterModel)
    fun delete(name: String)
    fun update(_name: String, _itemsCollected: Item, _dateCollected: LocalDate)
    fun deleteItemFromPlayer(name: String, _itemsCollected: Item, _dateCollected: LocalDate)
}