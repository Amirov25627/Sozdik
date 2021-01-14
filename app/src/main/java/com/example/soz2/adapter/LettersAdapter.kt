package com.example.soz2.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soz2.DetailsActivity
import com.example.soz2.databinding.LetterItemViewBinding
const val URL_PREFIX = "https://www.google.com/search?q="

class LettersAdapter : RecyclerView.Adapter<LetterViewHolder>() {

    private val letterList = ('A'..'Z').toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LetterItemViewBinding.inflate(layoutInflater, parent, false)
        return LetterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return letterList.size
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.bind(letterList[position])


    }

}

class LetterViewHolder(private val binding: LetterItemViewBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(char: Char) {
        binding.letterButton.text = char.toString()
        binding.letterButton.setOnClickListener {
            val detailsIntent = Intent(binding.root.context, DetailsActivity::class.java)
            detailsIntent.putExtra("letter", char)
            binding.root.context.startActivity(detailsIntent)}


        }
    }


