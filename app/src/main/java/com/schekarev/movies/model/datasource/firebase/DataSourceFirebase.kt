package com.schekarev.movies.model.datasource.firebase

import com.schekarev.movies.model.datasource.DataSource
import com.schekarev.movies.model.entity.Movie

interface DataSourceFirebase<T> : DataSource<T> {
    override suspend fun getData(): T
    suspend fun setData(movie: Movie?)
}