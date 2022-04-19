package com.cna.mobileprogramming.movieBuff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cna.mobileprogramming.movieBuff.adapter.MovieAdapter
import com.cna.mobileprogramming.movieBuff.repository.MainRepository
import com.cna.mobileprogramming.movieBuff.service.RetrofitService
import com.cna.mobileprogramming.movieBuff.viewmodel.MainViewModel
import com.cna.mobileprogramming.movieBuff.viewmodel.MyViewModelFactory
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cna.mobileprogramming.foodie.databinding.ActivityLanding2Binding
import com.cna.mobileprogramming.movieBuff.ui.MainActivity

class LandingActivity : AppCompatActivity() {

    lateinit var binding: ActivityLanding2Binding
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanding2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)

        binding.btnAllMovies.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnHighRated.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Type","HighRated")
            startActivity(intent)
        }

        binding.btnFav.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Type","Favorites")
            startActivity(intent)
        }
        binding.btnLatest.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Type","Latest")
            startActivity(intent)
        }

//        setContentView(R.layout.activity_landing2)
    }
}