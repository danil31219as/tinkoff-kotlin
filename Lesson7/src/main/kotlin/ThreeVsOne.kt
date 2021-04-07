import kotlin.concurrent.thread

fun main() {
    val data = CommonData()
    val writer = Thread {
        repeat(5) {
            ++data.i
            Thread.sleep(100)
        }
    }.apply { start() }
    val reader1 = Thread {
        var last_1 = 0
        while (data.i < 5) {
            if (data.i != last_1) {
                println("reader 1: ${data.i}")
                last_1 = data.i
            }
        }
    }.apply { start() }

    val reader2 = Thread {
        var last_2 = 0
        while (data.i < 5) {
            if (data.i != last_2) {
                println("reader 2: ${data.i}")
                last_2 = data.i
            }
        }
    }.apply { start() }

    val reader3 = Thread {
        var last_3 = 0
        while (data.i < 5) {
            if (data.i != last_3) {
                println("reader 3: ${data.i}")
                last_3 = data.i
            }
        }
    }.apply { start() }
}

class CommonData() {
    @Volatile
    var i = 0
}