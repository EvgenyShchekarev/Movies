package com.schekarev.movies.model

sealed class AppState {

    data class Success(val data: List<Movie>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}