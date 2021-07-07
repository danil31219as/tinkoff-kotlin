import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
class CarDataTest {
    @Test
    fun `should id less 5`(){
        val cars = listOf(CarData(1, "Ford"),
            CarData(2, "Mercedes"),
            CarData(3, "Apple"),
            CarData(4, "Mazda"),
            CarData(5, "Hyundai"))
        val result = CarInterface().getById(2, cars)
        assertEquals(result, CarData(2, "Mercedes"))
    }

    @Test
    fun `should id bigger 5`(){
        val cars = listOf(CarData(1, "Ford"),
            CarData(2, "Mercedes"),
            CarData(3, "Apple"),
            CarData(4, "Mazda"),
            CarData(5, "Hyundai"))
        val result = CarInterface().getById(10, cars)
        assertEquals(result, null)
    }

    @Test
    fun `should all`(){
        val cars = listOf(CarData(1, "Ford"),
            CarData(2, "Mercedes"),
            CarData(3, "Apple"),
            CarData(4, "Mazda"),
            CarData(5, "Hyundai"))
        val result = CarInterface().getAll(cars)
        assertEquals(result, cars)
    }
}