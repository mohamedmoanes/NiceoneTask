package com.moanes.niceonetask.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.moanes.niceonetask.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleCharactersLiveData()
        viewModel.getCharacters()

        viewModel.calculateCharactersAge()
    }

    private fun handleCharactersLiveData() {
        viewModel.charactersLiveData.observe(this, {
            Log.d("TEST", "test")
        })
    }
}