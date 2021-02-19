package transport

open class Car(
    override val name: String,
    override val capacity: Int, override val volumeTank: Int,
    override val typeofEnvironment: String = "ground", private var petrol: Int = volumeTank
) : Passenger {
    open fun start(){
        "Turn the ignition key".passengerPrint()
    }
    override fun refuel(){
        "fulling...".passengerPrint()
        petrol = volumeTank
    }

    override fun run(){
        "It drove 100 km".passengerPrint()
        petrol -= 12
    }

    override fun tankInfo(){
        "Left $petrol liters".passengerPrint()

    }

    fun stop() {
        "Watch out, the doors are closing".passengerPrint()
    }
}