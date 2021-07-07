import java.sql.Connection

class InitDB(val conn: Connection) {
    fun createBook(){
        val stmt = conn.createStatement()
        val sql = "CREATE TABLE IF NOT EXISTS Books (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT, year INT, author INT)"
        stmt.execute(sql)
    }

    fun createAuthor(){
        val stmt = conn.createStatement()
        val sql = "CREATE TABLE IF NOT EXISTS Authors (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT)"
        stmt.execute(sql)
    }
    fun createLibrary(){
        val stmt = conn.createStatement()
        val sql = "CREATE TABLE IF NOT EXISTS Libraries (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, city TEXT)"
        stmt.execute(sql)
    }
    fun createBookToLibrary(){
        val stmt = conn.createStatement()
        val sql = "CREATE TABLE IF NOT EXISTS book_library (book_id INTEGER, library_id INTEGER)"
        stmt.execute(sql)
    }

    fun deleteTable(tableName: String){
        val stmt = conn.createStatement()
        val sql = "DROP TABLE IF EXISTS $tableName"
        stmt.execute(sql)
    }
}