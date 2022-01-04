package com.schekarev.movies.utils.ui

import com.schekarev.movies.model.AppState
import com.schekarev.movies.model.entity.Movie

fun convertAppStateSuccessToEntity(appState: AppState): Movie? {
    return when (appState) {
        is AppState.Success -> {
            val result = appState.data
            result as Movie
            Movie(
                result.id,
                result.title,
                result.description,
                result.tagline,
                result.cast,
                result.rating,
                result.year,
                result.imageUrl,
                result.movieUrl
            )
        }
        else -> null
    }
}