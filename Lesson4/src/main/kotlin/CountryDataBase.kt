class CountryDataBase(private val data: List<Country>) {
    fun getItem(id: Int): List<Country> {
        if (data.any { it.id == id }) {
            return data.filter { it.id == id }
        }
        throw Exception("Empty data")


    }

    fun getItem(continent: String): List<Country> {
        if (data.any { it.continent == continent }) {
            return data.filter { it.continent == continent }
        }
        throw Exception("Empty data")
    }

    fun getItem(): List<Country> {
        return data
    }
}