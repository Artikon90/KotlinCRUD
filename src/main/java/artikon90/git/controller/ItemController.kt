package artikon90.git.controller

import artikon90.git.dao.ItemDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

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
        model.addAttribute("itemsById", itemDAO.getItemById(id))
        return "item/showItemPage"
    }

}