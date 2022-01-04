package com.schekarev.movies.view.main

import androidx.lifecycle.LiveData
import com.schekarev.movies.model.AppState
import com.schekarev.movies.view.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val interactor: MainInteractor) : BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }

    override fun getData() {
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch {
            startInteractor()
        }
    }

    private suspend fun startInteractor() = withContext(Dispatchers.IO) {
        _mutableLiveData.postValue(interactor.getData())
    }

    override fun handlerError(throwable: Throwable) {
        _mutableLiveData.postValue(AppState.Error(throwable))
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}
