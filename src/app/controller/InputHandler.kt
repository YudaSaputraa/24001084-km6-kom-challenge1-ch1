package app.controller

import app.App
import app.utils.IOUtils
import java.text.NumberFormat
import java.util.*

class InputHandler(
    private val foodData: FoodData,
    private val orderItem: OrderItem,
    private val deliveryServices: DeliveryOptions
) {
    private val formatRupiah = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    fun userInputHandler() {
        formatRupiah.maximumFractionDigits = 0
        val chooseItem: Int
        var payment: Int
        val chooseDelivery: Int?
        var orderedItems: Boolean
        try {
            print("Pilih Menu Makanan : ")
            chooseItem =
                IOUtils.getInputInteger() ?: throw NumberFormatException("Input yang Anda masukkan bukan angka!")
            val selectedMenu = foodData.getFoodByIndex(chooseItem)
            selectedMenu?.let {
                println("\nKamu memilih menu $chooseItem")
                println("Nama Menu\t\t\t: ${it.menuName}")
                println("Harga\t\t\t\t: ${formatRupiah.format(it.price)}")
                println("..................................")
                do {
                    print("Masukkan Pembayaran\t: Rp ")
                    payment = IOUtils.getInputInteger()
                        ?: throw NumberFormatException("Input yang Anda masukkan bukan angka!")
                    orderedItems = orderItem.orderItems(chooseItem, payment)
                    println("..................................")
                } while (!orderedItems)
                if (orderedItems) {
                    // Pilih metode pengiriman
                    deliveryServices.deliveryOptionDisplay()
                    print("Pilih metode pengiriman :")
                    chooseDelivery = IOUtils.getInputInteger()
                        ?: throw NumberFormatException("Input yang Anda masukkan bukan angka!")
                    deliveryServices.deliveryService(chooseDelivery)
                }
            } ?: App().printHeader()
        } catch (e: NumberFormatException) {
            println("Input yang anda masukkan bukan angka!")
            App().printHeader()
        }
    }

}