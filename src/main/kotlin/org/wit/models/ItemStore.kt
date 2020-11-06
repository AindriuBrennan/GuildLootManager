package org.wit.models

interface ItemStore {
   fun findOne(item: Item): Item?
   fun findAll(): List<Item>
   fun update(item: Item, charactersWithItem: String)
   fun delete(item: Item, charactersWithItem: String)
}