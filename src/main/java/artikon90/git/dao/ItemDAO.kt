package artikon90.git.dao

import artikon90.git.model.Item
import org.springframework.stereotype.Component

@Component
class ItemDAO {
    private val itemList = mutableListOf<Item>()
    init {
        itemList.add(Item(itemName = "Чашка", amount = 4))
        itemList.add(Item(itemName = "Комп", amount = 1))
        itemList.add(Item(itemName = "Клавиатура", amount = 2))
        itemList.add(Item(itemName = "Комп. мышка", amount = 2))
        itemList.add(Item(itemName = "Настольная лампа", amount = 1))
    }
    fun getItemList() = itemList
    fun getItemById(id:Int) = itemList.stream().filter {it -> it.itemId == id}.findAny().orElse(null)
    fun addNewItem(item:Item) = itemList.add(item)
    fun editItem(id:Int, item:Item) {
        val itemToEdit = getItemById(id)
        itemToEdit.itemName = item.itemName
        itemToEdit.amount = item.amount
    }
    fun deleteItem(id:Int) = itemList.removeIf { it -> it.itemId == id }
}