package com.schekarev.movies.model.repository.firebase

import com.schekarev.movies.model.datasource.firebase.DataSourceFirebase
import com.schekarev.movies.model.entity.Movie

class RepositoryFirebaseImplementation(private val firebaseDataSource: DataSourceFirebase<List<Movie?>>)
    : RepositoryFirebase<List<Movie?>> {

    override suspend fun getData(): List<Movie?> {
        return firebaseDataSource.getData()
    }

    override suspend fun setData(movie: Movie?) {
        firebaseDataSource.setData(movie)
    }

}