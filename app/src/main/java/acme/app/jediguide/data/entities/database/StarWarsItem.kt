package acme.app.jediguide.data.entities.database

import kotlinx.serialization.Serializable

data class StarWarsItem(
    val url: String,
    val name: String
) {
   var gender: String = ""
   var image: String = ""

}