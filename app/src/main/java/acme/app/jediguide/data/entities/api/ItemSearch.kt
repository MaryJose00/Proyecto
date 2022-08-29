package acme.app.jediguide.data.entities.api

data class ItemSearch(
    val codigo: Int,
    val error: Boolean,
    val mensaje: List<Mensaje>
)