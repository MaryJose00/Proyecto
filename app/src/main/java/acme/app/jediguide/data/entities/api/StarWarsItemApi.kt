package acme.app.jediguide.data.entities.api

data class StarWarsItemApi(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)