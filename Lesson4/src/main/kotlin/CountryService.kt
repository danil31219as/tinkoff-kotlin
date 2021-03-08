class CountryService(
    countries: CountryDataBase,
    countryAllies: CountryAlliesDataBase
) {
    private val data = countries.getItem().map {
        CountryWithAllies(
            it.id,
            it.name,
            it.population,
            it.continent,
            countryAllies.getItem(id = it.id).alliesIds,
            countryAllies.getItem(id = it.id).allianceNames
        )
    }

    fun getCountryWithAllies(): List<CountryWithAllies> {
        return data
    }

    fun sortedById(): List<CountryWithAllies> {
        return data.sortedBy { it.id }
    }

    fun sortedByName(): List<CountryWithAllies> {
        return data.sortedBy { it.name }
    }

    fun sortedByPopulation(): List<CountryWithAllies> {
        return data.sortedBy { it.population }
    }

    fun sortedByContinent(): List<CountryWithAllies> {
        return data.sortedBy { it.continent }
    }

    fun groupByContinent(): Map<String, List<CountryWithAllies>> {
        return data.groupBy { it.continent }
    }

    fun sizeFilter(predicate: (CountryWithAllies) -> Boolean): Int {
        return data.filter(predicate).count()
    }
}