package transport

class Train(
    override val name: String,
    override val tonnage: Int,
    override val capacity: Int,
    override val volumeTank: Int,
    override val typeofEnvironment: String = "ground",
    private var petrol: Int = volumeTank,
    private var currentTonnage: Int = 0
): Passenger, Cargo {
    override fun tonnageInfo() {
        "Current tonnage is $currentTonnage".cargoPrint()
    }

    override fun download(ton: Int) {
        if (ton + currentTonnage > tonnage) {
            "${ton + currentTonnage - tonnage} is over ton".cargoPrint()
            currentTonnage = tonnage
        } else {
            currentTonnage += ton
        }
    }

    override fun unload(ton: Int) {
        if (ton > currentTonnage) {
            "${ton - currentTonnage} is not enough to unload".cargoPrint()
            currentTonnage = 0
        } else {
            currentTonnage -= ton
        }
    }

    override fun refuel(){
        "fulling...".passengerPrint()
        petrol = volumeTank
    }

    override fun run(){
        "It drove 100 km and spent ${currentTonnage.toFloat() / tonnage * 20} liters".passengerPrint()
        petrol -= (currentTonnage.toFloat() / tonnage * 20).toInt()
    }

    override fun tankInfo(){
        "Left $petrol liters".passengerPrint()

    }

}