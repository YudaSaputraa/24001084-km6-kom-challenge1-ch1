package app.controller

import java.text.NumberFormat
import java.util.*

class OrderItem(private val foodData: FoodData) {
    private val formatRupiah = NumberFormat.getCurrencyInstance(Locale("id", "ID"))

    fun orderItems(selectedMenu: Int, payment: Int): Boolean {
        formatRupiah.maximumFractionDigits = 0
        val menuItemSelected = foodData.getFoodByIndex(selectedMenu)
        if (menuItemSelected != null && payment >= menuItemSelected.price) {
            println("Terimakasih! Anda berhasil memesan makanan!")
            println("Kembalian\t\t\t: ${formatRupiah.format(payment - menuItemSelected.price)}")
            return true
        } else {
            println("Maaf, pembayaran anda gagal!")
            return false
        }
    }



}