package transport

fun main() {
    val ford: Car = Car("Ford",5, volumeTank = 60)
    val tesla: ElectroCar = ElectroCar("Tesla",2)
    val passengerCar = listOf(ford, tesla)
    passengerCar.forEach{
        with(it){
            start()
            run()
            tankInfo()
            refuel()
            tankInfo()
            stop()
        }
    }
    val boing: Plane = Plane("Boing", 10)
    with(boing){
        unload(2)
        download(9)
        download(3)
        tonnageInfo()
        unload(16)
        tonnageInfo()
    }

    val sapsan: Train = Train("Sapsan", 100, 700, 1000)
    with(sapsan){
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