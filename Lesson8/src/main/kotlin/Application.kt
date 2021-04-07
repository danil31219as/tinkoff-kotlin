import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

data class StudentWithScore(val id: Int, val name: String, val score: Float)


fun main() = runBlocking {
    val student = async { ServiceStudent().getId(1) }.await()
    val score = async { ServiceScoreStudent().getId(1) }.await()
    println(StudentWithScore(student.id, student.name, score.score))
}




