package acme.app.jediguide.data.entities.api

import acme.app.jediguide.model.entities.StarWarsItemModel

data class Mensaje(
    val birth_year: String,
    val gender: String,
    val hair_color: String,
    val height: String,
    val id: String,
    val mass: String,
    val name: String,
    val skin_color: String,
    val url: String
)

fun Mensaje.getStarWarsItemModel(): StarWarsItemModel {
    val item = StarWarsItemModel(url, name)
    item.birth_year = birth_year
    item.gender = gender
    item.hair_color = hair_color
    item.height = height
    item.mass = mass
    item.skin_color = skin_color
    return item
}