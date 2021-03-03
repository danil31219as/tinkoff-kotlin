class Queue(val maxsize: Int) {
    private val queue = Array<Int>(maxsize) { 0 }
    private var tail = -1
    private var head = 0


    fun enqueue(element: Int) {
        if (tail == maxsize - 1) {
            tail = -1
        }
        queue[++tail] = element
    }

    fun dequeue(): Int {
        val first = queue[head]
        queue[head++] = 0
        if (head == maxsize) {
            head = 0
        }

        return first
    }

    override fun toString(): String {
        return queue.joinToString(" ")
    }

}