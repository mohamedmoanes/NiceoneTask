package com.moanes.niceonetask.ui

import com.moanes.datasource.model.Character
import com.moanes.datasource.repositories.CharactersRepo
import com.moanes.niceonetask.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(private val charactersRepo: CharactersRepo) :
    BaseViewModel() {
    private var lastOffset = 0
    private val limit = 10
    private var isLastPage = false

    fun getCharacters() = handelRequestLiveData<List<Character>> {
        val result = withContext(Dispatchers.IO) {
            charactersRepo.getCharacters(lastOffset, limit)
        }
        isLastPage = result.isEmpty()

        emit(result)
    }


    private fun loadNextPage() {
        if (!isLastPage) {
            lastOffset += limit
            getCharacters()
        }
    }
}