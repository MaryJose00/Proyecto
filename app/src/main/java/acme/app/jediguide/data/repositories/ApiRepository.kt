package acme.app.jediguide.data.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofit2(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://acme-api-jedi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}
