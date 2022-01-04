package com.schekarev.movies.view.main

import com.schekarev.movies.model.AppState
import com.schekarev.movies.model.entity.Movie
import com.schekarev.movies.model.repository.firebase.RepositoryFirebase
import com.schekarev.movies.view.InteractorGet

class MainInteractor(
    private val repositoryFirebase: RepositoryFirebase<List<Movie>>
) : InteractorGet<AppState> {

    override suspend fun getData() : AppState {
        return AppState.Success(repositoryFirebase.getData())
    }
}
