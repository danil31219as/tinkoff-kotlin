class Stack {
    var items: MutableList<Any> = mutableListOf()
    fun push(element: Any) {
        items.add(element)
    }

    fun pop(): Any? {
        if (items.isEmpty()) {
            return null
        } else {
            return items.removeAt(items.size - 1)
        }
    }

    override fun toString() = items.toString()
}