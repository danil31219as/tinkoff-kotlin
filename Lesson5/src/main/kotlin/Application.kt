import java.sql.SQLException

fun main() {
    var service = ServiceDB("main.db")
    service.init()
    val authors = listOf(Author(1, "Лев Толстой", mutableListOf(1)),
        Author(2, "Александр Пушкин", mutableListOf(2, 3)),
        Author(3, "Михаил Лермонтов", mutableListOf(4, 5)),
        Author(4, "Иван Тургенев", mutableListOf(6)))
    authors.forEach { service.insertAuthor(it) }
    val books = listOf(Book(1, "Война и мир", 1863, 1, mutableListOf(1, 2)),
        Book(2, "Дубровский", 1833, 2, mutableListOf(1, 3)),
        Book(3, "Капитанская дочка", 1836, 2, mutableListOf(2, 3)),
        Book(4, "Мцыри", 1839, 3, mutableListOf(3)),
        Book(5, "Демон", 1841, 3, mutableListOf(1, 2, 3)),
        Book(6, "Русский язык", 1882, 4, mutableListOf(1, 3)))
    books.forEach { service.insertBook(it) }
    val libraries = listOf(Library(1, "Moscow", mutableListOf(1, 2, 5, 6)),
        Library(2, "Saint Petersburg", mutableListOf(1, 3, 5)),
        Library(3, "Kazan", mutableListOf(2, 3, 4, 5, 6)))
    libraries.forEach { service.indertLibrary(it) }
    books.forEach { service.insertBookToLibrary(it) }
    println("Get by id:")
    try {
        println(service.getBook(10))
    } catch (e: SQLException){
        println(e)
    }

    try {
        println(service.getAuthor(2))
    } catch (e: SQLException){
        println(e)
    }
    try {
        println(service.getLibrary(1))
    } catch (e: SQLException){
        println(e)
    }
    println("Get '> 2' for example")
    try {
        println(service.filterBookPublication(">", 1840))
    } catch (e: SQLException){
        println(e)
    }

    println("JOIN")
    println(service.joinBookAuthor())
    println("GROUP BY")
    println(service.getCountLibraries())
    println("SORT")
    println(service.sortBooksByYear())
    service.close()
    service = ServiceDB("main.db")
    service.clear()
    service.close()





}