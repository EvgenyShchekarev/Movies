package com.schekarev.movies.model.repository.firebase

import com.schekarev.movies.model.entity.Movie
import com.schekarev.movies.model.repository.Repository

interface RepositoryFirebase<T> : Repository<T> {
    suspend fun setData(movie: Movie?)
}