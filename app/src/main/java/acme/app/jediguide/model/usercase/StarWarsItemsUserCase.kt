package acme.app.jediguide.model.usercase

import acme.app.jediguide.data.entities.api.getStarWarsItem
import acme.app.jediguide.data.entities.api.getStarWarsItemModel
import acme.app.jediguide.data.entities.database.StarWarsItem
import acme.app.jediguide.data.repositories.ApiRepository
import acme.app.jediguide.data.services.StarWarsItemsService
import acme.app.jediguide.model.entities.StarWarsItemModel

class StarWarsItemsUserCase {
    private val apiService = ApiRepository().getRetrofit().create(StarWarsItemsService::class.java)

    suspend fun getAllAnimeItems(page: Int): List<StarWarsItem> {
        val items: MutableList<StarWarsItem> = ArrayList()
        val call = apiService.getAllTopItems(page)

        println("orale fue ${call.isSuccessful}")

        if (call.isSuccessful) {
            call.body()?.results?.forEach {
               it -> val item = it.getStarWarsItem()
                item.image = "https://starwars-visualguide.com/assets/img/characters/22.jpg"
                //items.add(it.getStarWarsItem())
                items.add(item)
            }
        }
        return items
    }


    suspend fun getFullAnimeItem(url: String): StarWarsItemModel {
        var item: StarWarsItemModel? = null
        println("La url es $url")
        //val call = apiService.getOneFullItem(url)
        val call = apiService.getOneFullItem(url)
        if (call.isSuccessful) {
            item = call.body()?.getStarWarsItemModel()
            println("jol ${item?.name}")
        }
        return item ?: StarWarsItemModel()
    }
}