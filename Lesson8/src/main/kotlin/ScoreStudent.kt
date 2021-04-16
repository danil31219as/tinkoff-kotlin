import kotlinx.coroutines.delay

data class ScoreStudent(val studentId: Int, val score: Float)

class ServiceScoreStudent() {
    val data = listOf(ScoreStudent(1, 80f), ScoreStudent(2, 30f))
    suspend fun getId(id: Int): ScoreStudent {
        delay(1000L)
        return data[id - 1]
    }
}