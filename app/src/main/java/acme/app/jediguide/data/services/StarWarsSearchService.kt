package acme.app.jediguide.data.services

import acme.app.jediguide.data.entities.api.ItemSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsSearchService {

    @GET("users/{name}/")
    suspend fun getOneFullItem(@Path("name") id: String): Response<ItemSearch>
}