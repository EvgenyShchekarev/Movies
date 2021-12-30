package com.schekarev.movies.di

import com.schekarev.movies.view.MainInteractor
import com.schekarev.movies.view.MainViewModel
import com.schekarev.movies.model.Movie
import com.schekarev.movies.model.Repository
import com.schekarev.movies.model.RepositoryImplementation
import com.schekarev.movies.model.RetrofitImplementation
import org.koin.dsl.module

val application = module {
    single<Repository<List<Movie>>> { RepositoryImplementation(RetrofitImplementation()) }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get()) }
}