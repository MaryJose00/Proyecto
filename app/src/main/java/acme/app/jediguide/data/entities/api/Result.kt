package acme.app.jediguide.data.entities.api

import acme.app.jediguide.data.entities.database.StarWarsItem
import acme.app.jediguide.model.entities.StarWarsItemModel

data class Result(
    val birth_year: String,
    val created: String,
    val edited: String,
    val eye_color: String,
    val films: List<String>,
    val gender: String,
    val hair_color: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skin_color: String,
    val species: List<String>,
    val starships: List<String>,
    val url: String,
    val vehicles: List<String>
)

fun Result.getStarWarsItemModel(): StarWarsItemModel {
    val item = StarWarsItemModel(url, name)
    item.birth_year = birth_year
    item.created = created
    item.edited = edited
    item.eye_color = eye_color
    item.films = films
    item.gender = gender
    item.hair_color = hair_color
    item.height = height
    item.homeworld = homeworld
    item.mass = mass
    item.skin_color = skin_color
    item.species = species
    item.starships = starships
    item.vehicles = vehicles
    return item
}

fun Result.getStarWarsItem(): StarWarsItem {
    val item = StarWarsItem(url, name)
    item.gender = gender
    item.image = ""
    return item
}