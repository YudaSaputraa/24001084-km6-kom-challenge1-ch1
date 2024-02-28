package app.data_source

import app.model.FoodDataModel

interface FoodDataSource {
    fun getDataList(): List<FoodDataModel>
}

class FoodDataSourceImpl() : FoodDataSource {
    override fun getDataList(): List<FoodDataModel> {
        return listOf(
            FoodDataModel(
                "Ayam Bakar",
                50000
            ), FoodDataModel(
                "Ayam Goreng",
                40000
            ), FoodDataModel(
                "Ayam Geprek",
                40000
            ), FoodDataModel(
                "Kulit Ayam Crispy",
                15000
            ), FoodDataModel(
                "Sate Usus Ayam",
                5000
            )
        )
    }

}