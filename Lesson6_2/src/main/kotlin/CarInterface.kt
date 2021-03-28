class CarInterface {
    fun getById(id: Int, data: List<CarData>): CarData? {
        if (id > 0 && id < 5) {
            return data.filter { it.id == id }.first()
        } else {
            return null
        }
    }
    fun getAll(data: List<CarData>): List<CarData>{
        return data
    }
}