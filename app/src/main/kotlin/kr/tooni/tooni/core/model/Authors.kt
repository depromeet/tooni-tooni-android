package kr.tooni.tooni.core.model

data class Authors(
    val authorImage : String,
    val id: Long,
    val name: String,
) {

    companion object {

        val EMPTY = Authors(
            authorImage = "",
            id = 0,
            name = ""
        )
    }
}
