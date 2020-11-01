package models

interface ItemStore {
   fun findOne(id: Long): Item?
   fun update(item: Item)
   fun delete(item: Item)
}