data class Model(

    val result: ArrayList<Result>,
    val statusCode: String,
    val errorMessage: String,
    val paging: String
)


data class Result(

    val id: String,
    val title: String,
    val subCategories: List<SubCategories>
)

data class SubCategories(

    val id: String,
    val title: String
)
