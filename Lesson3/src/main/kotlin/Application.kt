fun main(args: Array<String>) {
    println("Queue:")
    var queue: Queue = Queue(mutableListOf("a", "b", 'c'))
    queue.enqueue(10)
    println(queue)
    println(queue.dequeue())
    println(queue)
    println("Stack:")
    var stack: Stack = Stack()
    with(stack) {
        push(5)
        push(14)
        push('c')
        push("56")
    }
    println(stack)
    println(stack.pop())
    println(stack)

}