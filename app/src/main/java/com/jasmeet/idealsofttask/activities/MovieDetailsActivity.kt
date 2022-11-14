package com.jasmeet.idealsofttask.activities

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.jasmeet.idealsofttask.R
import com.jasmeet.idealsofttask.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //full screen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title =intent.getStringExtra("title")
        binding.tvTitle.text = title

        val overview= intent.getStringExtra("overview")
        binding.tvOverview.text = overview

        val imagePath = intent.getStringExtra("poster_path")

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500$imagePath")
            .into(binding.image)

        val releaseDate = intent.getStringExtra("release_date")
        binding.tvReleaseDate.text = releaseDate

        val originalLanguage = intent.getStringExtra("original_language")
        binding.tvOriginalLang.text = originalLanguage

        val voteAverage = intent.getDoubleExtra("vote_average",0.0)
        binding.tvAverageVote.text = voteAverage.toString()

        binding.btnReveal.setOnClickListener {

            binding.btnReveal.postDelayed({
                binding.progressBar.visibility = View.VISIBLE
                binding.tvTitle.visibility = View.GONE
                binding.textView2.visibility = View.GONE
                binding.tvReleaseDate.visibility = View.GONE
                binding.tvLang.visibility = View.GONE
                binding.tvOriginalLang.visibility = View.GONE
                binding.tvVote.visibility = View.GONE
                binding.tvAverageVote.visibility = View.GONE
                binding.textView3.visibility = View.GONE
                binding.tvOverview.visibility = View.GONE
                binding.btnRate.visibility = View.GONE
            },200)

            binding.btnReveal.postDelayed({

                binding.btnReveal.visibility = View.GONE
                binding.progressBar.visibility = View.GONE
                binding.tvTitle.visibility = View.VISIBLE
                binding.textView2.visibility = View.VISIBLE
                binding.tvReleaseDate.visibility = View.VISIBLE
                binding.tvLang.visibility = View.VISIBLE
                binding.tvOriginalLang.visibility = View.VISIBLE
                binding.tvVote.visibility = View.VISIBLE
                binding.tvAverageVote.visibility = View.VISIBLE
                binding.textView3.visibility = View.VISIBLE
                binding.tvOverview.visibility = View.VISIBLE
                binding.btnRate.visibility = View.VISIBLE


            },2000)


        }

        binding.btnRate.setOnClickListener {
            openDialog()
        }

    }

    private fun openDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_layout)
        dialog.show()

        val cancelBtn = dialog.findViewById<Button>(R.id.btn_cancel)
        val rateBtn = dialog.findViewById<Button>(R.id.btn_rate)
        val ratingScale = dialog.findViewById<RatingBar>(R.id.rating)
        val textFeed = dialog.findViewById<TextView>(R.id.tvFeedback)


        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }
        rateBtn.setOnClickListener {
            val rating = ratingScale.rating
            textFeed.text = "Thank you for rating $rating stars"
            textFeed.visibility = View.VISIBLE

            cancelBtn.text = "CLOSE"
            rateBtn.setBackgroundColor(ContextCompat.getColor(this,R.color.primary))
            rateBtn.isEnabled = false

        }

    }
}