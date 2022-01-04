package com.schekarev.movies.model.datasource.firebase

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.schekarev.movies.model.AppState
import com.schekarev.movies.model.entity.Movie

class FirebaseImplementation : DataSourceFirebase<List<Movie?>> {

    companion object {
        private const val MOVIES_COLLECTION = "movies"
    }

    private val store = FirebaseFirestore.getInstance()
    private val moviesReference = store.collection(MOVIES_COLLECTION)

    override suspend fun getData(): List<Movie?> {
        val result = ArrayList<Movie?>()
        moviesReference.addSnapshotListener { snapshot, e ->
            e?.let {
                AppState.Error(e)
            }
            snapshot?.let {
                val movies = snapshot.documents.map { doc ->
                    doc.toObject(Movie::class.java)
                }
                result.addAll(movies)
            }
        }
        return result
    }

    override suspend fun setData(movie: Movie?) {
        movie?.let {
            moviesReference.document(it.id!!).set(movie)
        }
    }

    class SaveListMovie {

        private var _movies: List<Movie>

        init {
            _movies = ArrayList()
        }

        fun save(movies: List<Movie>) {
            this._movies = movies
        }
        fun get() : List<Movie?> {
            return _movies
        }
    }
}