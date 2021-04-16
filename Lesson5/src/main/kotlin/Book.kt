data class Book(
    val id: Int,
    val title: String,
    val publicationYear: Int,
    val authorId: Int,
    val libraryIds: List<Int>
)