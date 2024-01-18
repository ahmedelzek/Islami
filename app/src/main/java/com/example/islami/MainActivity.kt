package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadQuranFragment(savedInstanceState)

        handleClicks()
    }

    private fun handleClicks() {
        binding.navBarBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.quran -> {
                    loadFragment(QuranFragment())
                    true
                }

                R.id.hadeth -> {
                    loadFragment(HadethFragment())
                    true
                }

                R.id.radio -> {
                    loadFragment(RadioFragment())
                    true
                }

                R.id.sepha -> {
                    loadFragment(SephaFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun loadQuranFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            loadFragment(QuranFragment())
    }

}