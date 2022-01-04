package com.schekarev.movies.model.repository

interface Repository<T> {
    suspend fun getData() : T
}