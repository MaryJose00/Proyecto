package acme.app.jediguide.data.services

import acme.app.jediguide.data.entities.api.FullStarWarsItem
import acme.app.jediguide.data.entities.api.Result
import acme.app.jediguide.data.entities.api.StarWarsItemApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface StarWarsItemsService {

    // https://swapi.dev/api/
    @GET("people")
    suspend fun getAllTopItems(@Query("page") page: Int): Response<StarWarsItemApi>

    @GET("people/{id}/?format=json")
    suspend fun getOneFullItem(@Path("id") id: String): Response<Result>

   // @GET("people/2")
    //suspend fun getOneFullItem(): Response<Result>



}