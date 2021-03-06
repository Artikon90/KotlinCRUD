package artikon90.git.controller

import artikon90.git.dao.ItemDAO
import artikon90.git.model.Item
import artikon90.git.model.idCounter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/items")
class ItemController() {

    private lateinit var itemDAO: ItemDAO

    @Autowired
    constructor(itemDAO: ItemDAO) : this() {
        this.itemDAO = itemDAO
    }

    @GetMapping
    fun getItemsPage(model:Model): String {
        model.addAttribute("items", itemDAO.getItemList())
        return "item/itemsPage"
    }

    @GetMapping("/{id}")
    fun getItemPage(@PathVariable("id") id:Int, model:Model): String {
        model.addAttribute("itemById", itemDAO.getItemById(id))
        return "item/showItemPage"
    }
    @GetMapping("/{id}/edit")
    fun editPage(@PathVariable("id") id:Int, model:Model):String {
        model.addAttribute("itemToEdit", itemDAO.getItemById(id))
        return "item/editItemPage"
    }
    @PatchMapping("/{id}")
    fun editItem(@PathVariable("id") id:Int, @ModelAttribute("itemToEdit") item:Item): String {
        itemDAO.editItem(id, item)
        return "redirect:/items/${id}"
    }
    @GetMapping("/add")
    fun newItemPage(@ModelAttribute("itemToAdd") item:Item): String = "item/newItemPage"

    @PostMapping()
    fun addNewItem(@ModelAttribute("itemToAdd") item:Item): String {
        itemDAO.addNewItem(item)
        return "redirect:/items"
    }
    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable("id") id:Int): String {
        itemDAO.deleteItem(id)
        return "redirect:/items"
    }
}