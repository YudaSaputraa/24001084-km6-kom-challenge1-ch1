package app.data_source

import app.model.DeliveryDataModel

interface DeliveryDataSource {
    fun getDataList(): List<DeliveryDataModel>
}

class DeliveryDataSourceImpl : DeliveryDataSource {
    override fun getDataList(): List<DeliveryDataModel> {
        return listOf(
            DeliveryDataModel(
                "Take Away"
            ), DeliveryDataModel(
                "Delivery"
            )
        )
    }

}