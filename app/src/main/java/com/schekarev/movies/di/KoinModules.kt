package com.schekarev.movies.di

import com.schekarev.movies.model.datasource.firebase.FirebaseImplementation
import com.schekarev.movies.model.entity.Movie
import com.schekarev.movies.model.repository.firebase.RepositoryFirebase
import com.schekarev.movies.model.repository.firebase.RepositoryFirebaseImplementation
import com.schekarev.movies.view.add_movie.AddMovieInteractor
import com.schekarev.movies.view.add_movie.AddMovieViewModel
import com.schekarev.movies.view.main.MainInteractor
import com.schekarev.movies.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single<RepositoryFirebase<List<Movie?>>> {
        RepositoryFirebaseImplementation(
            FirebaseImplementation()
        )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get()) }
}

val addMovieScreen = module {
    factory { AddMovieViewModel(get()) }
    factory { AddMovieInteractor(get()) }
}