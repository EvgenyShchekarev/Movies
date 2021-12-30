package com.schekarev.movies.view

import com.schekarev.movies.model.AppState
import com.schekarev.movies.model.Movie
import com.schekarev.movies.model.Repository

class MainInteractor(
    private val repositoryRemote: Repository<List<Movie>>
) : Interactor<AppState> {

    override suspend fun getData(isOnline: Boolean) : AppState {
        val appState: AppState = if (isOnline) {
            AppState.Success(repositoryRemote.getData())
        } else {
            AppState.Success(null)
        }
        return appState
    }
}
