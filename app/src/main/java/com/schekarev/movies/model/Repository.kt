package com.schekarev.movies.model

interface Repository<T> {
    suspend fun getData(): T
}
