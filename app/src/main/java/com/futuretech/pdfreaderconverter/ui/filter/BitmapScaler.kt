package com.futuretech.pdfreaderconverter.ui.filter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.exifinterface.media.ExifInterface
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


// scale and keep aspect ratio
fun Context.scaleToFitWidth(b: Bitmap, width: Int): Bitmap {
    val factor = width / b.width.toFloat()
    return Bitmap.createScaledBitmap(b, width, (b.height * factor).toInt(), true)
}


// scale and keep aspect ratio
fun Context.scaleToFitHeight(b: Bitmap, height: Int): Bitmap {
    val factor = height / b.height.toFloat()
    return Bitmap.createScaledBitmap(b, (b.width * factor).toInt(), height, true)
}


// scale and keep aspect ratio
fun Context.scaleToFill(b: Bitmap, width: Int, height: Int): Bitmap {
    val factorH = height / b.width.toFloat()
    val factorW = width / b.width.toFloat()
    val factorToUse = if (factorH > factorW) factorW else factorH
    return Bitmap.createScaledBitmap(
        b, (b.width * factorToUse).toInt(),
        (b.height * factorToUse).toInt(), true
    )
}


// scale and don't keep aspect ratio
fun Context.strechToFill(b: Bitmap, width: Int, height: Int): Bitmap {
    val factorH = height / b.height.toFloat()
    val factorW = width / b.width.toFloat()
    return Bitmap.createScaledBitmap(
        b, (b.width * factorW).toInt(),
        (b.height * factorH).toInt(), true
    )
}

fun rotateBitmapOrientation(photoFilePath: String?): Bitmap? {
    // Create and configure BitmapFactory
    val bounds = BitmapFactory.Options()
    bounds.inJustDecodeBounds = true
    BitmapFactory.decodeFile(photoFilePath, bounds)
    val opts = BitmapFactory.Options()
    val bm = BitmapFactory.decodeFile(photoFilePath, opts)
    // Read EXIF Data
    var exif: ExifInterface? = null
    try {
        exif = photoFilePath?.let { ExifInterface(it) }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    val orientString: String = exif?.getAttribute(ExifInterface.TAG_ORIENTATION)!!
    val orientation =
        orientString.toInt() ?: ExifInterface.ORIENTATION_NORMAL
    var rotationAngle = 0
    if (orientation == ExifInterface.ORIENTATION_ROTATE_90) rotationAngle = 90
    if (orientation == ExifInterface.ORIENTATION_ROTATE_180) rotationAngle = 180
    if (orientation == ExifInterface.ORIENTATION_ROTATE_270) rotationAngle = 270
    // Rotate Bitmap
    val matrix = Matrix()
    matrix.setRotate(rotationAngle.toFloat(), bm.width.toFloat() / 2, bm.height.toFloat() / 2)
    // Return result
    return Bitmap.createBitmap(bm, 0, 0, bounds.outWidth, bounds.outHeight, matrix, true)
}

fun bitmapToFile(bitmap: Bitmap?, file: File, format: Bitmap.CompressFormat, quality: Int): File {
    return try {

        //Convert bitmap to byte array
        val bos = ByteArrayOutputStream()
        bitmap?.compress(format, quality, bos) // YOU can also save it in JPEG
        val bitmapdata = bos.toByteArray()

        //write the bytes in file
        val fos = FileOutputStream(file)
        fos.write(bitmapdata)
        fos.flush()
        fos.close()
        file
    } catch (e: Exception) {
        e.printStackTrace()
        file // it will return null
    }
}