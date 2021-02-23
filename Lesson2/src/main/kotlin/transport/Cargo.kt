package transport

interface Cargo {
    val name: String
    val tonnage: Int
    val typeofEnvironment: String
    fun tonnageInfo()
    fun download(ton: Int)
    fun unload(ton: Int)
    fun String.cargoPrint() {
        println("Cargo transport $name is ready to go by $typeofEnvironment with $tonnage ton on a deck!")
        println(this)
        println()
    }
}