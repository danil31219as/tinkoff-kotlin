fun main() {
    val countries = CountryDataBase(
        listOf(
            Country(1, "UK", 70_000_000, "Eurasia"),
            Country(2, "USA", 450_000_000, "North America"),
            Country(3, "France", 65_000_000, "Eurasia"),
            Country(4, "Canada", 35_000_000, "North America")
        )
    )
    val countryAllies = CountryAlliesDataBase(
        listOf(
            CountryAllies(1, listOf("G-7", "EU"), listOf(2, 3, 4)),
            CountryAllies(
                2,
                listOf("G-7", "North American Union"),
                listOf(1, 4)
            ),
            CountryAllies(3, listOf("G-7", "EU"), listOf(1)),
            CountryAllies(
                4,
                listOf("G-7", "North American Union"),
                listOf(1, 2)
            )
        )
    )
    println(countries.getItem(id = 2))
    println(countries.getItem(continent = "Eurasia"))

    println(countryAllies.getItem("North American Union"))

    val countryWithAllies = CountryService(countries, countryAllies)
    println(countryWithAllies.getCountryWithAllies())
    println(countryWithAllies.sizeFilter({ it.population >= 70_000_000 }))
}