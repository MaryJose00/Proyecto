package acme.app.jediguide.model.entities

data class StarWarsItemModel(val url: String = "", val name: String = "") {
    var birth_year: String? = ""
    var created: String? = ""
    var edited: String? = ""
    var eye_color: String? = ""
    var films: List<String>? = null
    var gender: String? = ""
    var hair_color: String? = ""
    var height: String? = ""
    var homeworld: String? = ""
    var mass: String? = ""
    var skin_color: String? = ""
    var species: List<String>? = null
    var starships: List<String>? = null
    var vehicles: List<String>? = null
}