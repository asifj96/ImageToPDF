package com.futuretech.pdfreaderconverter.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.futuretech.pdfreaderconverter.data.repo.FileRepository
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.model.ImageQueue
import com.futuretech.pdfreaderconverter.utility.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FileViewModel(application: Application) : AndroidViewModel(application) {

    val allFiles: LiveData<List<FileModel>>
    private val repository = FileRepository(application)

    init {
        allFiles = repository.allFiles
    }

    suspend fun insertFile(file: FileModel) = viewModelScope.launch(Dispatchers.IO) {

        repository.insertFile(file)
    }

    fun deleteFile(file: FileModel) = viewModelScope.launch(Dispatchers.IO) {
        val value = repository.deleteFile(file)
        Logger.debug("VALUE", value.toString())

    }

    fun deleteFileByTitle(title: String) = viewModelScope.launch(Dispatchers.IO) {
        val value = repository.deleteFileByTitle(title)
        Logger.debug("VALUE", value.toString())

    }

    /*  suspend fun deleteFileById(id: Int) = viewModelScope.launch(Dispatchers.IO) {

          repository.deleteFileById(id)
      }

      suspend fun deleteAllFiles() = viewModelScope.launch(Dispatchers.IO) {

          repository.deleteAllFiles()
      }*/

    suspend fun updateFile(
        title: String,
        timestamp: String,
        noOfImages: Int,
        imagesList: ArrayList<ImageQueue>,
        isPdf: Boolean,
        origionalName: String,

        ) = viewModelScope.launch(Dispatchers.IO) {

        repository.updateFile(
            title,
            timestamp,
            noOfImages,
            imagesList,
            isPdf,
            origionalName
        )
    }
}