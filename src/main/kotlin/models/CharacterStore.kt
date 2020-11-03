package models

interface CharacterStore {
    fun findOne(name: String): CharacterModel?
    fun findAll(): List<CharacterModel>
    fun create(characterModel: CharacterModel)
    fun delete(characterModel: CharacterModel)
    fun update(characterModel: CharacterModel)
}