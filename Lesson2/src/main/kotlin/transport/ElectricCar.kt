package transport

class ElectricCar(
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

    fun run(distance: Int){
        "It drove $distance km".passengerPrint()
        accumulator -= (distance.toFloat() / 100 * 20).toInt()
    }
    fun run(how: String){
        var consumption: Int = 0
        when(how){
            "fast" -> consumption = 30
            "slow" -> consumption = 10
        }
        accumulator -= consumption
        "It drove 100 km".passengerPrint()

    }

    override fun tankInfo() {
        "Left $accumulator%".passengerPrint()

    }
}