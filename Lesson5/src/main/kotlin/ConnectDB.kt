import java.sql.DriverManager
import java.sql.ResultSet

class ConnectDB (nameDB: String){
    val conn = DriverManager.getConnection( "jdbc:sqlite:./$nameDB")
    val init = InitDB(conn)

    fun executeSql(query: String, injection: String): ResultSet{
        val preparedStatement = conn.prepareStatement(query)
        preparedStatement.setString(1, injection)
        val resultSet = preparedStatement.executeQuery()
        return resultSet
    }
    fun executeSql(query: String): ResultSet{
        val preparedStatement = conn.prepareStatement(query)
        val resultSet = preparedStatement.executeQuery()
        return resultSet
    }

    fun execute(query: String){
        val stmt = conn.createStatement()
        val resultSet = stmt.execute(query)
        stmt.close()
    }

    fun disConnect(){
        conn.close()
    }

    fun createTables(){
        with(init){
            createBook()
            createAuthor()
            createLibrary()
            createBookToLibrary()
        }
    }

    fun deleteTables(){
        listOf("Books", "Authors", "Libraries", "book_library").forEach { init.deleteTable(it) }
    }
}