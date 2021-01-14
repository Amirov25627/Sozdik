package com.example.soz2.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soz2.R
import com.example.soz2.databinding.ActivityDetailsBinding
import com.example.soz2.databinding.LetterItemViewBinding

class WordsAdapter(private val context: Context, private val letter: Char) : RecyclerView.Adapter<WordsViewHolder>() {

    private val wordsList = context.resources.getStringArray(R.array.words).toList()
    private val filteredList = wordsList.filter { it.startsWith(letter, ignoreCase = true) }
        .shuffled()
        .take(5)
        .sorted()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
val layoutInflater = LayoutInflater.from(context)
        val binding = LetterItemViewBinding.inflate(layoutInflater, parent, false)
        return WordsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.bind(filteredList[position])
    }

}

class WordsViewHolder(private val binding: LetterItemViewBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(word:String){
binding.letterButton.text = word
        binding.letterButton.setOnClickListener {
        val searchIntent = Intent(Intent.ACTION_VIEW)
        val urlString = URL_PREFIX + word
        val uri = Uri.parse(urlString)
        searchIntent.data = uri
        binding.root.context.startActivity(searchIntent)}
    }
}