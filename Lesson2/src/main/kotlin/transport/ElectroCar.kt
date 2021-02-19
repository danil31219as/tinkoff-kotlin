package transport

class ElectroCar(
    override val name: String,
    override val capacity: Int,
    override val typeofEnvironment: String = "ground",
    private var accumulator: Int = 100
) : Car(name, capacity, 100), Passenger {
    override fun start() {
        "Click the button".passengerPrint()
    }

    override fun refuel() {
        "charging...".passengerPrint()
        accumulator = 100
    }

    override fun run() {
        "It drove 100 km".passengerPrint()
        accumulator -= 20
    }

    override fun tankInfo() {
        "Left $accumulator%".passengerPrint()

    }
}