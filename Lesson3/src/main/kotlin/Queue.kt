class Queue {
    private val queue = mutableListOf<Any>()
    private var tail = -1
    private var head = 0


    fun enqueue(element: Any) {
        if (tail == queue.size - 1) {
            queue.add(0)
        }
        queue[++tail] = element
    }

    fun dequeue(): Any? {
        if (head < queue.size) {
            val first = queue[head]
            queue[head++] = 0
            return first
        } else {
            return null
        }
    }

    override fun toString(): String {
        return queue.joinToString(" ")
    }

}