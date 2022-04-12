package com.futuretech.pdfreaderconverter.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.futuretech.pdfreaderconverter.data.repo.ImageQueueRepository
import com.futuretech.pdfreaderconverter.model.ImageQueue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageQueueViewModel(application: Application) : AndroidViewModel(application) {

    private val allQueueImages: LiveData<List<ImageQueue>>
    private val repository = ImageQueueRepository(application)

    init {
        allQueueImages = repository.allQueueImages
    }

    suspend fun insertQueueImage(image: ImageQueue) = viewModelScope.launch(Dispatchers.IO) {

        repository.insertQueueImage(image)
    }

    suspend fun deleteQueueImage(image: ImageQueue) = viewModelScope.launch(Dispatchers.IO) {

        repository.deleteQueueImage(image)
    }

    fun deleteAllQueueImages() = viewModelScope.launch(Dispatchers.IO) {

        repository.deleteAllQueueImages()
    }
}