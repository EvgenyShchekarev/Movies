package com.schekarev.movies.view.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.schekarev.movies.R
import com.schekarev.movies.databinding.LoadingLayoutBinding
import com.schekarev.movies.model.AppState
import com.schekarev.movies.model.entity.Movie
import com.schekarev.movies.utils.ui.AlertDialogFragment
import com.schekarev.movies.view.InteractorGet

private const val DIALOG_FRAGMENT_TAG = "74a54328-5d62-46bf-ab6b-cbf5d8c79522"

abstract class BaseFragment<T : AppState, I : InteractorGet<T>> : Fragment() {

    private lateinit var binding: LoadingLayoutBinding
    abstract val model: BaseViewModel<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoadingLayoutBinding.inflate(layoutInflater)
    }

    protected fun renderData(appState: T) {
        when (appState) {
            is AppState.Success -> {
                showViewWorking()
                appState.data?.let {
                    it as List<Movie>
                    if (it.isEmpty()) {
                        showAlertDialog(
                            getString(R.string.dialog_tittle_sorry),
                            getString(R.string.empty_server_response_on_success)
                        )
                    } else {
                        setDataToAdapter(it)
                    }
                }
            }
            is AppState.Loading -> {
                showViewLoading()
                if (appState.progress != null) {
                    binding.progressBarHorizontal.visibility = View.VISIBLE
                    binding.progressBarRound.visibility = View.GONE
                    binding.progressBarHorizontal.progress = appState.progress
                } else {
                    binding.progressBarHorizontal.visibility = View.GONE
                    binding.progressBarRound.visibility = View.VISIBLE
                }
            }
            is AppState.Error -> {
                showViewWorking()
                showAlertDialog(getString(R.string.error_stub), appState.error.message)
            }
        }
    }

    private fun showViewLoading() {
        binding.loadingFrameLayout.visibility = View.VISIBLE
    }

    private fun showViewWorking() {
        binding.loadingFrameLayout.visibility = View.GONE
    }

    private fun showNoInternetConnectionDialog() {
        showAlertDialog(
            getString(R.string.dialog_title_device_is_offline),
            getString(R.string.dialog_message_device_is_offline)
        )
    }

    private fun showAlertDialog(title: String?, message: String?) {
        AlertDialogFragment.newInstance(title, message)
            .show(childFragmentManager, DIALOG_FRAGMENT_TAG)
    }

    private fun isDialogNoll() =
        childFragmentManager.findFragmentByTag(DIALOG_FRAGMENT_TAG) == null

    abstract fun setDataToAdapter(data: List<Movie>)
}