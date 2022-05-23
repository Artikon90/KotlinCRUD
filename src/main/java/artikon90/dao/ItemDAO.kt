package artikon90.dao

import artikon90.model.Item

class ItemDAO {
    private val itemList = mutableListOf<Item>()
    init {
        itemList.add(Item(itemName = "Cup", amount = 4))
        itemList.add(Item(itemName = "PC", amount = 1))
        itemList.add(Item(itemName = "Keyboard", amount = 2))
        itemList.add(Item(itemName = "PC Mouse", amount = 2))
        itemList.add(Item(itemName = "Lamp", amount = 1))
    }
    fun getItemList() = itemList

}