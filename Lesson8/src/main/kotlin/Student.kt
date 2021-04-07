import kotlinx.coroutines.delay

data class Student (val id: Int, val name: String)

class ServiceStudent(){
    val data = listOf(Student(1, "Bob"), Student(2, "Peter"))
    suspend fun getId(id: Int): Student{
        delay(1000L)
        return data[id - 1]
    }
}