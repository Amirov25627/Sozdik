package com.example.soz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.soz2.adapter.WordsAdapter
import com.example.soz2.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val receievedLetter: Char? = intent.extras?.getChar("letter")
        setContentView(binding.root)
        binding.wordsRV.adapter = WordsAdapter(this, receievedLetter ?: 'A')


    }
}