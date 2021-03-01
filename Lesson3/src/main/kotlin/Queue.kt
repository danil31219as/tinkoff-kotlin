class Queue(list: MutableList<Any>) {
    var items: MutableList<Any> = list

    fun enqueue(element: Any) {
        items.add(element)
    }

    fun dequeue(): Any? {
        if (items.isEmpty()) {
            return null
        } else {
            return items.removeAt(0)
        }
    }

    override fun toString() = items.toString()
}