class Stack(val maxsize: Int) {
    var top: Int = -1
    private val stack = Array<Int>(maxsize) { 0 }
    fun push(element: Int) {
        if (top == maxsize - 1) {
            top = -1
        }
        stack[++top] = element
    }

    fun pop(): Int {
        val head = stack[top]
        stack[top--] = 0
        return head
    }

    override fun toString(): String {
        return stack.joinToString(" ")
    }
}