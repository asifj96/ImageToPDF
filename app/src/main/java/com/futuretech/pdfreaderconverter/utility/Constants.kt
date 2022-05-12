package com.futuretech.pdfreaderconverter.utility

import com.google.android.gms.ads.nativead.NativeAd

object Constants {

    val STORAGE_PERMISSION: Array<String> = arrayOf(
        "android.permission.WRITE_EXTERNAL_STORAGE",
        "android.permission.READ_EXTERNAL_STORAGE"
    )
    const val FILENAME = "yyyy-MM-dd-HH-mm-ss-SSS"
    const val PHOTO_EXTENSION = ".png"
    const val REQUEST_WRITE_PERMISSION = 100
    const val RC_CAMERA_PERM = 124
    const val RC_GALLERY_PERM = 125
    const val IMAGE_POS = "IMAGE_POS"
    const val CROP = "CROP"
    const val PDF = "PDF"
    const val FILTERS = "FILTERS"
    const val IMAGE_URI_PATH = "IMAGE_URI_PATH"
    const val IMAGE_QUEUE_LIST = "IMAGE_QUEUE_LIST"
    const val PDF_FILE_OBJECT = "PDF_FILE_OBJECT"
    const val PDF_FILE_ARRAY_LIST = "PDF_FILE_ARRAY_LIST"
    const val FILE_URI = "FILE_URI"
    const val PDF_FILE_FRAGMENT = "PDF_FILE_FRAGMENT"
    const val FILE_MODEL_OBJ = "FILE_MODEL_OBJ"
    const val FILE_PATH = "FILE_PATH"
    const val ACTION_OPEN = 0
    const val ACTION_SHARE = 1
    const val ACTION_RENAME = 2
    const val ACTION_DELETE = 3
    const val GALLERY_IMAGE = "GALLERY_IMAGE"
    const val ACTION_SAVE_GALLERY = 4
    const val ACTION_TAP = 7
    const val LONG_CLICK = 8
    const val ACTION_SEARCH = 9
    const val ACTION_CLICK = 10
    const val ACTION_LONG_CLICK = 11
    const val ACTION_CROP = 100
    const val ACTION_FILTERS = 101
    const val ACTION_RETAKE = 102
    const val DRAFT_OPERATION_RESULT = 200
    const val CAMERA_RESULT = 202
    const val DRAFT_SELECTION_RESULT = 201
    const val GALLERY_PICKER_RESULT = 203
    const val FILTER_IMAGE_RESULT = 204
    const val SIGNATURE_RESULT = 206
    const val CROP_IMAGE_RESULT = 205
    const val RETAKE_IMAGE_RESULT = 206

    const val COLOR_BLACK = "COLOR_BLACK"
    const val COLOR_WHITE = "COLOR_WHITE"
    const val COLOR_YELLOW = "COLOR_YELLOW"
    const val COLOR_BROWN = "COLOR_BROWN"
    const val COLOR_BLUE = "COLOR_BLUE"
    const val COLOR_GREEN = "COLOR_GREEN"
    const val COLOR_PURPLE = "COLOR_PURPLE"

    var mainFullNativeAd: NativeAd? = null

}