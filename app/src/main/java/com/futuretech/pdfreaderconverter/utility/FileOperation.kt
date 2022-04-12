package com.futuretech.pdfreaderconverter.utility

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.futuretech.pdfreaderconverter.R
import java.io.File

object FileOperation {

    fun Context.getRealPathFromURI(contentURI: Uri): String {
        val result: String?
        val cursor: Cursor? = contentResolver.query(contentURI, null, null, null, null)
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.path
        } else {
            cursor.moveToFirst()

            /* val idx = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                 cursor.getColumnIndex(MediaStore.Images.ImageColumns.RELATIVE_PATH)
             } else {
                 cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
             }*/
            val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            result = cursor.getString(idx)
            cursor.close()
        }
        return result.toString()
    }

    fun Context.getOutputFileDirectory(dir: String): File {
        val appContext = applicationContext
        val mediaDir = getExternalFilesDir(null)?.let {
            File(it, dir).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists()) mediaDir else appContext.filesDir
    }

    private fun Context.isDirectoryNotEmpty(): Boolean =
        getOutputFileDirectory(resources.getString(R.string.app_name)).listFiles()
            ?.isNotEmpty() == true

    fun Context.getUriPath(path: String): Uri {
        return FileProvider.getUriForFile(
            this,
            "${packageName}.provider", File(path)
        )
    }

}