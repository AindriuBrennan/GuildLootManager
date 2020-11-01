package models

interface CharacterStore {
    fun findOne(id: Long): Character?
    fun create(character: Character)
    fun delete(character: Character)
    fun update(character: Character)
}