package models

interface ItemStore {
   fun findOne(itemToFind: Item): Item?
   fun findAll(): List<Item>
   fun update(itemToUpdate: Item, charactersWithItem: String)
   fun delete(item: Item)
}