import java.lang.Exception

class Car(var consumption: Int = 10) {
    fun getFuel(distance: Int) = (consumption * distance).toFloat() / 100
    fun isDrive(liters: Int, distance: Int) = getFuel(distance) <= liters
}

class CarService(val car: Car){
    fun checkDangerSituation(liters: Int,distance: Int) {
        if (!car.isDrive(liters, distance)){
            throw Exception("there is not fuel needed")
        }
        if (car.getFuel(distance) > 100){
            throw Exception("there is not big tank")
        }
    }

}
