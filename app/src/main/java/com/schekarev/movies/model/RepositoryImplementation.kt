package com.schekarev.movies.model

class RepositoryImplementation(private val dataSource: DataSource<List<Movie>>) :
    Repository<List<Movie>> {

    override suspend fun getData(): List<Movie> {
        return dataSource.getData()
    }
}