package com.schekarev.movies.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.schekarev.movies.model.AppState
import com.schekarev.movies.model.Movie
import com.schekarev.movies.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<AppState, MainInteractor>() {

    private lateinit var binding: FragmentMainBinding
    override lateinit var model: MainViewModel
    private val adapter: MainAdapter by lazy { MainAdapter(onListItemClickListener) }

    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: Movie) {
                Toast.makeText(activity, "$data", Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        initViewModel()
        initView()
        return binding.root
    }

    override fun setDataToAdapter(data: List<Movie>) {
        adapter.setData(data)
    }

    private fun initViewModel() {
        if (binding.recyclerMain.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        val viewModel: MainViewModel by viewModel()
        model = viewModel
        model.subscribe().observe(viewLifecycleOwner) {
            renderData(it)
        }
    }

    private fun initView() {
        binding.recyclerMain.layoutManager =
            GridLayoutManager(activity, 2)
        binding.recyclerMain.adapter = adapter
    }
}