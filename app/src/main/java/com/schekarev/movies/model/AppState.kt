package com.schekarev.movies.model

import com.schekarev.movies.model.entity.Movie

sealed class AppState {
    data class Success(var data: List<Movie?>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}