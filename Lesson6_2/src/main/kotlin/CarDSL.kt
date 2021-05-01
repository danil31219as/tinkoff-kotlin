data class CarDSL(
    var company: String = "",
    var mileage: Int = 0,
    var visitedCities: MutableList<String> = mutableListOf()
) {
    fun addMileage(distance: Int){
        mileage += distance
    }
}

fun carDSL(block: CarDSL.() -> Unit): CarDSL = CarDSL().apply(block)