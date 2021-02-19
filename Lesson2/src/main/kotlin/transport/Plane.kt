package transport

class Plane(
    override val name: String,
    override val tonnage: Int,
    override val typeofEnvironment: String = "air",
    private var currentTonnage: Int = 0
) : Cargo {

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
}