package app.controller

import app.data_source.DeliveryDataSourceImpl

interface DeliveryService {
    fun deliver()
}

class TakeAwayImpl : DeliveryService {
    override fun deliver() {
        repeat(1) {
            print("Makananu sedang dimasak (5 detik) ")
            repeat(5) {
                Thread.sleep(1000)
                print(". ")
            }

            print("\nMakananmu sudah siap! Silahkan ambil di resto ya! (5 detik) ")
            repeat(5) {
                Thread.sleep(1000)
                print(". ")
            }
            print("\nPesananmu selesai! (3 detik) ")
            repeat(3) {
                Thread.sleep(1000)
                print(". ")
            }

        }
    }

}

class DeliveryImpl : DeliveryService {
    override fun deliver() {
        repeat(1) {
            print("Makananu sedang dimasak (5 detik) ")
            repeat(5) {
                Thread.sleep(1000)
                print(". ")
            }
            print("\nMakananmu sudah siap! Driver segera menuju tempatmu! (5 detik) ")
            repeat(5) {
                Thread.sleep(1000)
                print(". ")
            }
            print("\nDrive sampai! Pesanan selesai! (3 detik) ")
            repeat(3) {
                Thread.sleep(1000)
                print(". ")
            }
        }
    }

}

class DeliveryOptions {
    private val deliveryMethod = DeliveryDataSourceImpl().getDataList()
    val takeAway = TakeAwayImpl()
    val delivery = DeliveryImpl()
    fun deliveryService(index: Int) {
        val options = if (index in 1..deliveryMethod.size) {
            println("${deliveryMethod[index - 1].optionName}")
            println("..................................")
            when (index) {
                1 -> takeAway.deliver()

                2 -> delivery.deliver()

                else -> {
                    println("Opsi pengiriman tidak tersedia!")

                }
            }

        } else {
            println("Opsi tidak tersedia!")
            print("Pilih metode Pengiriman : ")
            deliveryService(readln().toInt())
        }

    }

    fun deliveryOptionDisplay() {
        println("\nMetode pengiriman : ")
        deliveryMethod.forEachIndexed { index, data ->
            println("${index + 1}. ${data.optionName}")
        }
    }

}


