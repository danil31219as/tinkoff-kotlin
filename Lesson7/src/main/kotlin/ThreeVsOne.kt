import kotlin.concurrent.thread

fun main() {
    var i = 0
    repeat(100) {
        thread {
            println("1: $i")
            println("2: $i")
            println("3: $i")
            i++

        }
    }
}