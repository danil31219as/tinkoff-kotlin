class CountryAlliesDataBase(private val data: List<CountryAllies>) {
    fun getItem(id: Int): List<CountryAllies> {
        if (data.any { it.countryId == id }) {
            return data.filter { it.countryId == id }
        }
        throw Exception("Empty data")
    }

    fun getItem(allianceName: String): List<CountryAllies> {
        if (data.any { allianceName in it.allianceNames }) {
            return data.filter { allianceName in it.allianceNames }
        }
        throw Exception("Empty data")
    }

    fun getItem(): List<CountryAllies> {
        return data
    }

}