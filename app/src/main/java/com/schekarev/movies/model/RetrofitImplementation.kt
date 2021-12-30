package com.schekarev.movies.model

class RetrofitImplementation : DataSource<List<Movie>> {

    companion object {
        fun getD(): List<Movie> {
            return listOf(
                Movie(1, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg"),
                Movie(2, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg"),
                Movie(3, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg"),
                Movie(4, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg"),
                Movie(5, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg")
            )
        }
    }

    override suspend fun getData(): List<Movie> {
        return listOf(
            Movie(1, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg"),
            Movie(2, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg"),
            Movie(3, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg"),
            Movie(4, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg"),
            Movie(5, "Title", "https://phonoteka.org/uploads/posts/2021-07/1625676540_2-phonoteka-org-p-pop-art-merlin-krasivo-2.jpg")
        )
    }
}