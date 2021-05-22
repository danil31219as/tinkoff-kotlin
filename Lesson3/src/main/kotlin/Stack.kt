class Stack {
    var top: Int = -1
    private val stack = mutableListOf<Any>()
    fun push(element: Any) {
        if (top == stack.size - 1) {
            stack.add(0)
        }
        stack[++top] = element
    }

    fun pop(): Any? {
        if (top >= 0) {
            val head = stack[top]
            stack[top--] = 0
            return head
        } else {
            return null
        }
    }

    override fun toString(): String {
        return stack.joinToString(" ")
    }
}