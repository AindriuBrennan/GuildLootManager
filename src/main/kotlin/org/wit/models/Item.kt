package org.wit.models

/**
 * Item Model which users will be able to add to players
 *
 */
class Item (
        val id: Long? =0,
        val name: String = "",
        var playersWithItem: ArrayList<String>? = ArrayList()
)
