class CountryAlliesDataBase(private val data: List<CountryAllies>) {
    fun getItem(id: Int): CountryAllies {
        return data.filter { it.countryId == id }[0]
    }

    fun getItem(allianceName: String): List<CountryAllies>{
        return data.filter { allianceName in it.allianceNames }
    }

    fun getItem(): List<CountryAllies>{
        return data
    }

}