package com.jasmeet.idealsofttask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.jasmeet.idealsofttask.adapter.MovieListAdapter
import com.jasmeet.idealsofttask.api.ApiMovieInterface
import com.jasmeet.idealsofttask.api.ApiMovieUtilities
import com.jasmeet.idealsofttask.databinding.FragmentMoviesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(layoutInflater)

        getMovieList()

        return binding.root
    }

    private fun getMovieList() {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = ApiMovieUtilities.getInstance().create(ApiMovieInterface::class.java).getMovieData()

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = MovieListAdapter(requireContext(),response.body()!!.results)
            }

           // Log.d("Noob is good", "getMovieData: ${response.body()!!.results} " )
        }
    }

}
