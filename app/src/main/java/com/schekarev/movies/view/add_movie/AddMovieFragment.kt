package com.schekarev.movies.view.add_movie

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.schekarev.movies.databinding.FragmentAddMovieBinding
import com.schekarev.movies.model.entity.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class AddMovieFragment : Fragment() {

    private lateinit var binding: FragmentAddMovieBinding

    private var movie: Movie? = null
    private lateinit var model: AddMovieViewModel

    private val onSaveButtonClickListener: View.OnClickListener =
        View.OnClickListener {
            movie?.let {
                model.saveMovie(it)
            }
        }

    private var textWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            saveMovie()
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun afterTextChanged(p0: Editable?) {}

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddMovieBinding.inflate(layoutInflater)
        initViewModel()
        initView()
        return binding.root
    }

    private fun initViewModel() {
        val viewModel: AddMovieViewModel by viewModel()
        model = viewModel
    }

    private fun initView() {
        removeTextChangedListener()
        addTextChangedListener()
        binding.saveBtn.setOnClickListener(onSaveButtonClickListener)
    }

    private fun addTextChangedListener() {
        binding.titleEt.addTextChangedListener(textWatcher)
        binding.descriptionEt.addTextChangedListener(textWatcher)
        binding.taglineEt.addTextChangedListener(textWatcher)
        binding.castEt.addTextChangedListener(textWatcher)
        binding.yearEt.addTextChangedListener(textWatcher)
        binding.ratingEt.addTextChangedListener(textWatcher)
        binding.imageUrlEt.addTextChangedListener(textWatcher)
        binding.movieUrlEt.addTextChangedListener(textWatcher)
    }

    private fun removeTextChangedListener() {
        binding.titleEt.removeTextChangedListener(textWatcher)
        binding.descriptionEt.removeTextChangedListener(textWatcher)
        binding.taglineEt.removeTextChangedListener(textWatcher)
        binding.castEt.removeTextChangedListener(textWatcher)
        binding.yearEt.removeTextChangedListener(textWatcher)
        binding.ratingEt.removeTextChangedListener(textWatcher)
        binding.imageUrlEt.removeTextChangedListener(textWatcher)
        binding.movieUrlEt.removeTextChangedListener(textWatcher)
    }

    private fun saveMovie() {
        if (binding.titleEt.text == null || binding.titleEt.text!!.length < 3) return
        if (binding.descriptionEt.text == null || binding.descriptionEt.text!!.length < 3) return
        if (binding.imageUrlEt.text == null || binding.imageUrlEt.text!!.length < 3) return

        movie = Movie(
            UUID.randomUUID().toString(),
            binding.titleEt.text.toString(),
            binding.descriptionEt.text.toString(),
            binding.taglineEt.text.toString(),
            binding.castEt.text.toString(),
            binding.yearEt.text.toString(),
            binding.ratingEt.text.toString(),
            binding.imageUrlEt.text.toString(),
            binding.movieUrlEt.text.toString()
        )
    }
}