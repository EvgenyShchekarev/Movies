package com.schekarev.movies.model.datasource

interface DataSource<T> {
    suspend fun getData(): T
}