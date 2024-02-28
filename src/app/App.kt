package app

import app.controller.DeliveryOptions
import app.controller.FoodData
import app.controller.InputHandler
import app.controller.OrderItem
import app.utils.IOUtils
import java.text.NumberFormat
import java.util.*

class App() {
    private val formatRupiah = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    private val foodData = FoodData()
    private val orderItem = OrderItem(foodData)
    private val deliveryServices = DeliveryOptions()
    private val userInputHandling = InputHandler(foodData, orderItem, deliveryServices)


    fun run() {
        printHeader()
    }

    fun printHeader() {
        println(
            """
                ===================================
                         WARUNG MAKAN AJA!
                ===================================
            """.trimIndent()
        )
        foodData.displayFood()
        userInputHandling.userInputHandler()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}



