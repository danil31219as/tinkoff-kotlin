import java.sql.SQLException

class ServiceDB(nameDB: String) {
    val connection = ConnectDB(nameDB)
    fun init() {
        connection.createTables()
    }

    fun clear(){
        connection.deleteTables()
    }

    fun insertBook(obj: Book) {
        val query =
            "INSERT INTO Books (title, year, author) VALUES ('${obj.title}', ${obj.publicationYear}, ${obj.authorId})"
        connection.execute(query)
    }

    fun insertAuthor(obj: Author) {
        val query = "INSERT INTO Authors (name) VALUES ('${obj.name}')"
        connection.execute(query)
    }

    fun indertLibrary(obj: Library) {
        val query = "INSERT INTO Libraries (city) VALUES ('${obj.city}')"
        connection.execute(query)
    }

    fun insertBookToLibrary(obj: Book) {
        obj.libraryIds.forEach { connection.execute("INSERT INTO book_library (book_id, library_id) VALUES (${obj.id}, $it)") }
    }

    fun getBook(id: Int): Book {
        val bookInfo =
            connection.executeSql("SELECT id, title, year, author FROM Books WHERE id = ?",
                id.toString())
        val libraryInfo =
            connection.executeSql("SELECT library_id FROM book_library WHERE book_id = ?",
                id.toString())
        val libraries = mutableListOf<Int>()
        while (libraryInfo.next()) {
            libraries.add(libraryInfo.getInt("library_id"))
        }
        while (bookInfo.next()) {
            return Book(bookInfo.getInt("id"),
                bookInfo.getString("title"),
                bookInfo.getInt("year"),
                bookInfo.getInt("author"),
                libraries)
        }
        throw SQLException("$id id not found")
    }

    fun getAuthor(id: Int): Author {
        val authorInfo =
            connection.executeSql("SELECT id, name FROM Authors WHERE id = ?",
                id.toString())
        val bookInfo =
            connection.executeSql("SELECT id FROM Books WHERE author = ?",
                id.toString())
        val books = mutableListOf<Int>()
        while (bookInfo.next()) {
            books.add(bookInfo.getInt("id"))
        }
        while (authorInfo.next()) {
            return Author(authorInfo.getInt("id"),
                authorInfo.getString("name"),
                books)
        }
        throw SQLException("$id id not found")
    }

    fun getLibrary(id: Int): Library {
        val libraryInfo =
            connection.executeSql("SELECT id, city FROM Libraries WHERE id = ?",
                id.toString())
        val bookInfo =
            connection.executeSql("SELECT book_id FROM book_library WHERE library_id = ?",
                id.toString())
        val books = mutableListOf<Int>()
        while (bookInfo.next()) {
            books.add(bookInfo.getInt("book_id"))
        }
        while (libraryInfo.next()) {
            return Library(libraryInfo.getInt("id"),
                libraryInfo.getString("city"),
                books)
        }
        throw SQLException("$id id not found")
    }

    fun filterBookPublication(how: String, limit: Int): MutableList<Book> {
        val bookInfo =
            connection.executeSql("SELECT id, title, year, author FROM Books WHERE year $how ?",
                limit.toString())
        val books = mutableListOf<Book>()
        while (bookInfo.next()) {
            val libraryInfo =
                connection.executeSql("SELECT library_id FROM book_library WHERE book_id = ?",
                    bookInfo.getString("id"))
            val libraries = mutableListOf<Int>()
            while (libraryInfo.next()) {
                libraries.add(libraryInfo.getInt("library_id"))
            }
            books.add(Book(bookInfo.getInt("id"),
                bookInfo.getString("title"),
                bookInfo.getInt("year"),
                bookInfo.getInt("author"),
                libraries))
        }
        if (books.isNotEmpty()) {
            return books
        } else {
            throw SQLException("Not found suitable values")
        }
    }

    fun joinBookAuthor(): MutableList<BookAuthor> {
        val bookAuthorInfo =
            connection.executeSql("Select Books.id, Books.title, Books.year, Authors.name from Books inner join Authors on Books.author = Authors.id")
        val booksAuthors = mutableListOf<BookAuthor>()
        while (bookAuthorInfo.next()) {
            val libraryInfo =
                connection.executeSql("SELECT library_id FROM book_library WHERE book_id = ?",
                    bookAuthorInfo.getString("id"))
            val libraries = mutableListOf<Int>()
            while (libraryInfo.next()) {
                libraries.add(libraryInfo.getInt("library_id"))
            }
            booksAuthors.add(BookAuthor(bookAuthorInfo.getInt("id"),
                bookAuthorInfo.getString("title"),
                bookAuthorInfo.getInt("year"),
                bookAuthorInfo.getString("name"), libraries))
        }
        return booksAuthors
    }

    fun getCountLibraries(): MutableMap<Int, Int> {
        val bookLibrariesCount = mutableMapOf<Int, Int>()
        val queryCount =
            connection.executeSql("select book_id, count(library_id) from book_library group by book_id")
        while (queryCount.next()) {
            bookLibrariesCount.put(queryCount.getInt("book_id"),
                queryCount.getInt("count(library_id)"))
        }
        return bookLibrariesCount
    }

    fun sortBooksByYear(): MutableList<Book> {
        val bookInfo =
            connection.executeSql("select * from Books order by year desc")
        val books = mutableListOf<Book>()
        while (bookInfo.next()) {
            val libraryInfo =
                connection.executeSql("SELECT library_id FROM book_library WHERE book_id = ?",
                    bookInfo.getString("id"))
            val libraries = mutableListOf<Int>()
            while (libraryInfo.next()) {
                libraries.add(libraryInfo.getInt("library_id"))
            }
            books.add(Book(bookInfo.getInt("id"),
                bookInfo.getString("title"),
                bookInfo.getInt("year"),
                bookInfo.getInt("author"),
                libraries))
        }
        return books
    }


    fun close() {
        connection.disConnect()
    }
}
