package artikon90.model

class Item() {
    var idCounter : Int = 0
    var itemName : String = " "
    var itemId : Int = 0
    var amount : Int = 0

    constructor(itemName: String, amount: Int) : this() {
        this.itemName = itemName
        this.itemId = ++idCounter
        this.amount = amount
    }

    override fun toString(): String {
        return "Item(itemName='$itemName', itemId=$itemId, amount=$amount)"
    }
}