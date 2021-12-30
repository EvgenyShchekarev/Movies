package com.schekarev.movies.view

interface Interactor<T> {
    suspend fun getData(isOnline: Boolean): T
}
