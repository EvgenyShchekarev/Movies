package com.schekarev.movies.view.add_movie

import com.schekarev.movies.model.entity.Movie
import com.schekarev.movies.model.repository.firebase.RepositoryFirebase
import com.schekarev.movies.view.InteractorSet

class AddMovieInteractor(
    private val repositoryFirebase: RepositoryFirebase<List<Movie>>
) : InteractorSet<Movie> {

    override suspend fun setData(movie: Movie) {
        repositoryFirebase.setData(movie)
    }
}