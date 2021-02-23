package transport

fun main() {
    val ford: Car = Car("Ford", 5, volumeTank = 60)
    val tesla: ElectricCar = ElectricCar("Tesla", 2)
    with(tesla) {
        run(200)
        tankInfo()
        run("slow")
        tankInfo()
        refuel()
    }
    val passengerCar = listOf(ford, tesla)
    passengerCar.forEach {
        with(it) {
            start()
            run()
            tankInfo()
            refuel()
            tankInfo()
            stop()
        }
    }
    val boeing: Plane = Plane("Boeing", 10)
    with(boeing) {
        unload(2)
        download(9)
        download(3)
        tonnageInfo()
        unload(16)
        tonnageInfo()
    }

    val sapsan: Train = Train("Sapsan", 100, 700, 1000)
    with(sapsan) {
        download(70)
        run()
        download(40)
        unload(10)
        tonnageInfo()
        run()
        tankInfo()
        refuel()
        unload(100)
    }
}