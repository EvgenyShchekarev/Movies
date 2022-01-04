package com.schekarev.movies.view

import com.schekarev.movies.model.entity.Movie

interface InteractorSet<T> : Interactor<T> {
    suspend fun setData(movie: Movie)
}