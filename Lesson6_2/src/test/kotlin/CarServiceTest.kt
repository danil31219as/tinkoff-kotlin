import io.mockk.every
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.Assertions.assertEquals
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.slot

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.lang.Exception

@ExtendWith(MockKExtension::class)
class CarServiceTest {
    val slotA = slot<Int>()
    val slotB = slot<Int>()
    @Test
    fun `should not enough fuel`(){
        val car = mockk<Car>()
        every { car.isDrive(capture(slotA), capture(slotB)) } returns false
        val carService = CarService(car)
        val result = assertThrows(Exception::class.java) {
            carService.checkDangerSituation(5, 100)
        }
        assertEquals("there is not fuel needed", result.message)
    }
    @Test
    fun `should too little tank`(){
        val car = mockk<Car>()
        every { car.getFuel(capture(slotA)) } returns 200.0F
        val carService = CarService(car)
        val result = assertThrows(Exception::class.java) {
            carService.checkDangerSituation(20, 100)
        }
        assertEquals("there is not big tank", result.message)
    }
}