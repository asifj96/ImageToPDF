package com.futuretech.pdfreaderconverter.ui.pdfFiles

import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.media.MediaScannerConnection
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.extension.hasSdkHigherThan
import com.futuretech.pdfreaderconverter.extension.showToast
import com.futuretech.pdfreaderconverter.model.PdfFile
import com.futuretech.pdfreaderconverter.utility.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class PdfFilesViewModel(application: Application) : AndroidViewModel(application) {

    var isSuccess: Boolean = false
    private val _actions = MutableLiveData<PdfFile>()
    val actions: MutableLiveData<PdfFile> get() = _actions
    private val context: Application = getApplication<Application>()

    fun deleteFile(file: PdfFile) {
        viewModelScope.launch {

            file.uri?.let {
                context.contentResolver.delete(
                    it, "${MediaStore.Files.FileColumns._ID} = ?",
                    arrayOf(file.id.toString())
                )
            }
        }
    }

    @SuppressLint("LogNotTimber")
    fun renameFile(
        file: PdfFile,
        newName: String,
    ) {
        viewModelScope.launch {
            if (hasSdkHigherThan(Build.VERSION_CODES.R)) {
                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY),
                    file.id.toLong()
                )

                val newValues = ContentValues().apply {
                    put(MediaStore.Files.FileColumns.TITLE, newName)
                    put(MediaStore.Files.FileColumns.DATE_MODIFIED, System.currentTimeMillis())
                    put(MediaStore.Files.FileColumns.DISPLAY_NAME, newName)
                    put(MediaStore.Files.FileColumns.IS_PENDING, 0)
                }
                try {
                    context.contentResolver.update(
                        contentUri,
                        newValues,
                        "${MediaStore.Files.FileColumns._ID} = ?",
                        arrayOf(file.id.toString())
                    )
                    isSuccess = true

                } catch (securityException: SecurityException) {
                    Log.d(
                        "TAG",
                        "updateFile: ${securityException.printStackTrace()} \tcause: ${securityException.cause}"
                    )
                }
            } else {
                val oldFile = File(file.path)
                val extension = file.path.substring(file.path.lastIndexOf("."))
                val newFile =
                    File("${File(file.path).parent!!}/${newName}${extension}")
                if (!newFile.exists()) {
                    if (oldFile.renameTo(newFile)) {
                        /* file.name = newName
                         file.path = newFile.absolutePath*/
                        isSuccess = true
                        addDocument(context, newFile)
                        removeDocument(context, oldFile)
                    } else {
                        Log.d("TAG", "updateMedia: rename failed.")
                        withContext(Dispatchers.Main) {
                            context.showToast(
                                context.getString(
                                    R.string.file_already_exist
                                )
                            )
                        }
                    }
                } else {
                    Log.d("TAG", "updateMedia: rename failed.")
                    withContext(Dispatchers.Main) {
                        context.showToast(
                            context.getString(
                                R.string.file_already_exist
                            )
                        )
                    }
                }
            }
        }
    }

    private fun removeDocument(c: Context, f: File) {
        MediaScannerConnection.scanFile(c, arrayOf(f.toString()), null) { path, uri ->
            Logger.debug("ExternalStorage", "Scanned $path:")
            Logger.debug("ExternalStorage", "-> uri=$uri")
        }
    }

    private fun addDocument(c: Context, f: File?) {
        MediaScannerConnection.scanFile(c, arrayOf(f.toString()), null) { path, uri ->
            Logger.debug("ExternalStorage", "Scanned $path:")
            Logger.debug("ExternalStorage", "-> uri=$uri")
        }
    }
}