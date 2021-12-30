package com.schekarev.movies.model

interface DataSource<T> {
    suspend fun getData(): T
}