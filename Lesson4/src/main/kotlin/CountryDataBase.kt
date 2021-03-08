class CountryDataBase(private val data: List<Country>) {
    fun getItem(id: Int): Country {
        return data.filter { it.id == id }[0]
    }

    fun getItem(continent: String): List<Country> {
        return data.filter { it.continent == continent }
    }

    fun getItem(): List<Country> {
        return data
    }
}