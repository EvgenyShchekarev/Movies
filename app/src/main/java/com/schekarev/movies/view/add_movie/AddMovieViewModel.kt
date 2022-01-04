package com.schekarev.movies.view.add_movie

import com.schekarev.movies.model.AppState
import com.schekarev.movies.model.entity.Movie
import com.schekarev.movies.view.base.BaseViewModel
import kotlinx.coroutines.launch

class AddMovieViewModel(private val addMovieInteractor: AddMovieInteractor) :
    BaseViewModel<AppState>() {

    fun saveMovie(movie: Movie) {
        viewModelCoroutineScope.launch {
            addMovieInteractor.setData(movie)
        }
    }

    override fun getData() {
        TODO("Not yet implemented")
    }

    override fun handlerError(throwable: Throwable) {
        TODO("Not yet implemented")
    }
}