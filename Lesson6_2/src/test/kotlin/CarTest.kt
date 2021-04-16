import io.mockk.every
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.Assertions.assertEquals

import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Test
@ExtendWith(MockKExtension::class)
class CarTest {
    @Test
    fun `getFuel should multiply for 100`(){
        val car = Car(30)
        val result = car.getFuel(100)
        assertEquals(30.0, result)
    }

    @Test
    fun `getFuel should multiply for any`(){
        val car = Car(30)
        val result = car.getFuel(50)
        assertEquals(15.0, result)
    }
    @Test
    fun `fuel should be enough`(){
        val car = Car(40)
        val result = car.isDrive(30, 60)
        assertEquals(true, result)
    }

    @Test
    fun `fuel should not be enough`(){
        val car = Car(40)
        val result = car.isDrive(10, 60)
        assertEquals(false, result)
    }
}