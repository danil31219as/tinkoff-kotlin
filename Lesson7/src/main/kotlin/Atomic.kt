import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

fun main() {
    val executor10 = Executors.newFixedThreadPool(10)
    val executor20 = Executors.newFixedThreadPool(20)
    val executor30 = Executors.newFixedThreadPool(30)
    val features_time = mutableListOf<Future<Long>>()
    val rating = mutableMapOf<String, Long>()
    executor10.submit(Callable {
        val start = System.nanoTime()
        val i = AtomicInteger()
        repeat(1_000_000) { i.incrementAndGet()}
        System.nanoTime() - start
    }).also { features_time.add(it) }
    rating.set("10 pool", features_time.sumOf { it.get() })
    features_time.clear()
    executor10.shutdown()

    executor20.submit(Callable {
        val start = System.nanoTime()
        val i = AtomicInteger()
        repeat(1_000_000) { i.incrementAndGet() }
        System.nanoTime() - start
    }).also { features_time.add(it) }
    rating.set("20 pool", features_time.sumOf { it.get() })
    features_time.clear()
    executor20.shutdown()

    executor30.submit(Callable {
        val start = System.nanoTime()
        val i = AtomicInteger()
        repeat(1_000_000) { i.incrementAndGet() }
        System.nanoTime() - start
    }).also { features_time.add(it) }
    rating.set("30 pool", features_time.sumOf { it.get() })
    features_time.clear()
    executor30.shutdown()

    println(rating.toList()
        .sortedBy { (key, value) -> value }
        .forEach{ (key, value) -> println("result of $key is $value ns" ) })

}