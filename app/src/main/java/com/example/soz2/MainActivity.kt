package com.example.soz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soz2.adapter.LettersAdapter
import com.example.soz2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var isLinear = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { isLinear = it.getBoolean("linear", true) }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateRecycler()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("linear", isLinear)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_layout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.switchLayout) {
            isLinear = !isLinear
            updateMenuIcon(item)
            updateRecycler()
        }
        if (item.itemId == R.id.dummy) {
            Toast.makeText(this, "STAR!", Toast.LENGTH_LONG).show()
        }
        return true
    }

    private fun updateMenuIcon(menuItem: MenuItem){
        if (isLinear){
            menuItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_grid)
        } else {
            menuItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_linear)
        }
    }

    private fun updateRecycler(){
        if (isLinear) {
            binding.letters.layoutManager = LinearLayoutManager(this)
        } else {
            binding.letters.layoutManager = GridLayoutManager(this, 4)
        }
        binding.letters.adapter = LettersAdapter()
    }

}