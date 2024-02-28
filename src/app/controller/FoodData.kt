package app.controller

import app.data_source.FoodDataSourceImpl
import app.model.FoodDataModel
import java.text.NumberFormat
import java.util.*

class FoodData {
    private val formatRupiah = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    private val menuItems = FoodDataSourceImpl().getDataList()

    fun displayFood() {
        formatRupiah.maximumFractionDigits = 0
        println("List Menu Makanan : ")
        menuItems.forEachIndexed { index, items ->
            println("${index + 1}. ${items.menuName} [${formatRupiah.format(items.price)}/porsi]")
        }

    }

    fun getFoodByIndex(index: Int): FoodDataModel? {
        val selectedItems = if (index in 1..menuItems.size) {
            menuItems[index - 1]
        } else {
            println("Menu tidak tersedia!")
            null
        }

        return selectedItems
    }
}