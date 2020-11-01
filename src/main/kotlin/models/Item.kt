package models

class Item (
        val id: Long? =0,
        val name: String = "",
        var playersWithItem: List<Character>,
)
