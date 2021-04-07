import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class DSLTest {
    @Test
    fun `should mock in dsl style`(){
        val car = mockk<CarDSL>{
            every { company } returns "Ford"
            every { mileage } returns 100
            every { visitedCities } returns mutableListOf("Moscow", "Berlin", "New York")
        }
        assertAll()
    }
}