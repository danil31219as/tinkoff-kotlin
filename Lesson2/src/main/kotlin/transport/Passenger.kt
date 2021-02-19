package transport

interface Passenger {
    val name: String
    val capacity: Int
    val volumeTank: Int
    val typeofEnvironment: String
    fun refuel()
    fun run()
    fun tankInfo()
    fun String.passengerPrint(){
        println("You're welcome! Passenger transport $name: capacity - $capacity, by travel space - $typeofEnvironment")
        println(this)
        println()
    }


}