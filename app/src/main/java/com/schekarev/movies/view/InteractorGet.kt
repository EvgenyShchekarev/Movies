package com.schekarev.movies.view

interface InteractorGet<T> : Interactor<T> {
    suspend fun getData(): T
}
