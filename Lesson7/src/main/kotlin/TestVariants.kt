import java.lang.Thread.MAX_PRIORITY
import java.lang.Thread.MIN_PRIORITY

fun main() {
    val t1 = MyThread().apply { start() }
    t1.join()

    val t2 = Thread(MyRun())
    t2.start()
    t2.join()

    val t_usual = MyDaemon()
    val t_daemon = MyDaemon()
    t_daemon.setDaemon(true)
    t_daemon.start()
    t_usual.start()
    t_daemon.join()
    t_usual.join()


    repeat(20){
        val t_3 = MyThread1()
        val t_4 = MyThread2()
        t_3.start()
        t_4.start()
    }
    println("-----------------------------------------")
    repeat(20){
        val t_3 = MyThread1()
        val t_4 = MyThread2()
        t_3.setPriority(MAX_PRIORITY)
        t_4.setPriority(MIN_PRIORITY)
        t_3.start()
        t_4.start()


    }

}

class MyThread: Thread() {
    override fun run() {
        println("It is Thread on ${Thread.currentThread().name}")
    }
}
class MyThread1: Thread() {
    override fun run() {
        println("It is first Thread")
    }
}
class MyThread2: Thread() {
    override fun run() {
        println("It is second Thread")
    }
}

class MyRun : Runnable {
    override fun run() {
        println("It is Runnable on ${Thread.currentThread().name}")
    }
}

class MyDaemon : Thread() {
    override fun run() {
    try{
        if (isDaemon()){
            println("start daemon")
            sleep(3000)
        } else{
            println("start usual")
        }
    } catch (e: InterruptedException){
        println(e)
    } finally {
        if (!isDaemon){
            println("end usual")
        } else{
            println("end daemon")
        }
    }
    }
}