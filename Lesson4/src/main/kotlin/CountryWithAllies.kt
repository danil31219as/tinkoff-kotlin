data class CountryWithAllies(
    val id: Int,
    val name: String,
    val population: Int,
    val continent: String,
    val alliesIds: List<Int>,
    val allianceNames: List<String>
)