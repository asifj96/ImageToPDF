package com.futuretech.pdfreaderconverter.extension

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.database.ContentObserver
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.text.Editable
import android.text.format.DateFormat
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.dialog.ConfirmationDialog
import com.futuretech.pdfreaderconverter.dialog.LoadingDialog
import com.futuretech.pdfreaderconverter.model.RootItem
import com.futuretech.pdfreaderconverter.utility.Constants.FILENAME
import com.futuretech.pdfreaderconverter.utility.Constants.PHOTO_EXTENSION
import pub.devrel.easypermissions.EasyPermissions
import java.io.File
import java.io.FileOutputStream
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Context.showToast(str: String) {
    Toast.makeText(this, str, Toast.LENGTH_LONG).show()
}

fun Context.getRootItemArrayList(): ArrayList<RootItem> {
    val rootItemArrayList: ArrayList<RootItem> = ArrayList()

    rootItemArrayList.add(
        RootItem(
            R.drawable.ic_home_icon,
            getString(R.string.home_files)
        )
    )
    rootItemArrayList.add(
        RootItem(
            R.drawable.ic_import_from_camera,
            getString(R.string.import_from_camera)
        )
    )
    rootItemArrayList.add(
        RootItem(
            R.drawable.ic_import_from_gallery,
            getString(R.string.import_from_gallery)
        )
    )
    rootItemArrayList.add(
        RootItem(
            R.drawable.ic_share_icon,
            getString(R.string.share_app)
        )
    )
    return rootItemArrayList
}

fun Context.getCurrentDate(): String {

    val formatDate: String?
    var date: Date? = null
    val getCurrentDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(
        Date()
    )
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    try {
        date = formatter.parse(getCurrentDate)
        Log.e("formatted date ", date.toString() + "")
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    formatDate = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(date!!)

    return formatDate
}


fun Context.shareApp() {
    try {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Image To PDF")
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            "${getString(R.string.share_app_text)}$packageName"
        )
        shareIntent.type = "text/plain"
        startActivity(shareIntent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun hasSdkHigherThan(sdk: Int): Boolean {
    return Build.VERSION.SDK_INT >= sdk
}

fun Context.rateUs(context: Context?) {
    val uri = Uri.parse("market://details?id=$packageName")
    val goToMarket = Intent(Intent.ACTION_VIEW, uri)
    // To count with Play market backstack, After pressing back button,
    // to taken back to our application, we need to add following flags to intent.
    goToMarket.addFlags(
        Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
    )
    try {
        context?.startActivity(goToMarket)
    } catch (e: ActivityNotFoundException) {
        context?.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            )
        )
    }
}

@SuppressLint("DefaultLocale")
fun Context.getSize(size: Long): String {
    var s = ""
    val kb = (size / 1024).toDouble()
    val mb = kb / 1024
    val gb = mb / 1024
    val tb = gb / 1024
    if (size < 1024L) {
        s = "$size Bytes"
    } else if (size >= 1024 && size < 1024L * 1024) {
        s = String.format("%.1f", kb) + " KB"
    } else if (size >= 1024L * 1024 && size < 1024L * 1024 * 1024) {
        s = String.format("%.1f", mb) + " MB"
    } else if (size >= 1024L * 1024 * 1024 && size < 1024L * 1024 * 1024 * 1024) {
        s = String.format("%.1f", gb) + " GB"
    } else if (size >= 1024L * 1024 * 1024 * 1024) {
        s = String.format("%.1f", tb) + " TB"
    }
    return "-\t${s}"
}

fun Context.getDate(time: Long): String {
    val cal = Calendar.getInstance(Locale.ENGLISH)
    cal.timeInMillis = time * 1000
    return DateFormat.format("dd-MMM-yy HH:mm", cal).toString()
}

var mLastClickTime: Long = 0

fun disableClick(): Boolean {
    if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
        return false
    }
    mLastClickTime = SystemClock.elapsedRealtime()
    return true
}

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

fun Context.getTitleCurrentDate(name: String): String {

    val formatDate: String?
    var date: Date? = null
    val getCurrentDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(
        Date(System.currentTimeMillis())
    )
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    try {
        date = formatter.parse(getCurrentDate)
        Log.e("formatted date ", date.toString() + "")
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    formatDate = SimpleDateFormat("MMddyyyyHHmmss", Locale.getDefault()).format(date!!)

    return "$name $formatDate"
}

fun Context.showLoadingDialog(
    parentFragmentManager: FragmentManager,
    title: String,
): LoadingDialog {
    val loadingAdDialog = LoadingDialog()
    loadingAdDialog.setTitle(title)
    loadingAdDialog.isCancelable = false
    loadingAdDialog.setStyle(
        DialogFragment.STYLE_NO_FRAME,
        R.style.CustomBottomSheetDialogTheme
    )
    if (!loadingAdDialog.isAdded) {
        loadingAdDialog.show(
            parentFragmentManager,
            LoadingDialog.TAG
        )
    }
    return loadingAdDialog
}

fun showConfirmationDialog(
    activity: Activity,
    parentFragmentManager: FragmentManager,
    onDialogAction: (Activity) -> Unit
) {

    val confirmationDialog =
        ConfirmationDialog(activity, fun(activity: Activity) {
            onDialogAction.invoke(activity)
        })
    confirmationDialog.isCancelable = false
    confirmationDialog.show(
        parentFragmentManager,
        ConfirmationDialog.TAG
    )
}

fun createFile(baseFolder: File) = File(
    baseFolder,
    SimpleDateFormat(
        FILENAME,
        Locale.US
    ).format(System.currentTimeMillis()) + PHOTO_EXTENSION
)

fun createPdfFile(baseFolder: File, format: String, extension: String) = File(
    baseFolder,
    format + extension
)

fun Context.getMainFrameBitmap(view: View): Bitmap? {
    val createBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
    view.draw(Canvas(createBitmap))
    return imageBitmap(createBitmap)
}

fun Context.imageBitmap(bitmap: Bitmap): Bitmap? {
    val width = bitmap.width
    var i = -1
    var height = bitmap.height
    var i2 = -1
    var i3 = width
    var i4 = 0
    while (i4 < bitmap.height) {
        var i5 = i2
        var i6 = i3
        for (i7 in 0 until bitmap.width) {
            if (bitmap.getPixel(i7, i4) shr 24 and 255 > 0) {
                if (i7 < i6) {
                    i6 = i7
                }
                if (i7 > i) {
                    i = i7
                }
                if (i4 < height) {
                    height = i4
                }
                if (i4 > i5) {
                    i5 = i4
                }
            }
        }
        i4++
        i3 = i6
        i2 = i5
    }
    return if (i < i3 || i2 < height) {
        null
    } else Bitmap.createBitmap(bitmap, i3, height, i - i3 + 1, i2 - height + 1)
}

fun rotateBitmap(bitmap: Bitmap, i: Int): Bitmap? {
    val matrix = Matrix()
    when (i) {
        1 -> return bitmap
        2 -> matrix.setScale(-1.0f, 1.0f)
        3 -> matrix.setRotate(180.0f)
        4 -> {
            matrix.setRotate(180.0f)
            matrix.postScale(-1.0f, 1.0f)
        }
        5 -> {
            matrix.setRotate(90.0f)
            matrix.postScale(-1.0f, 1.0f)
        }
        6 -> matrix.setRotate(90.0f)
        7 -> {
            matrix.setRotate(-90.0f)
            matrix.postScale(-1.0f, 1.0f)
        }
        8 -> matrix.setRotate(-90.0f)
        else -> return bitmap
    }
    return try {
        val createBitmap = Bitmap.createBitmap(
            bitmap,
            0,
            0,
            bitmap.width,
            bitmap.height,
            matrix,
            false
        )
        bitmap.recycle()
        createBitmap
    } catch (e: OutOfMemoryError) {
        e.printStackTrace()
        null
    }
}

fun File.writeBitmap(bitmap: Bitmap?, format: Bitmap.CompressFormat, quality: Int) {
    FileOutputStream(this).apply {
        bitmap?.compress(format, quality, this)
        close()
        flush()
    }
}

fun getCurrentTimeStamp(): String {
    val tsLong = System.currentTimeMillis() / 1000
    return tsLong.toString()
}

fun Context.showKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun Context.hideKeyboard(view: View) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (imm.isActive)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
}


fun ContentResolver.registerObserver(
    uri: Uri,
    observer: (selfChange: Boolean) -> Unit,
): ContentObserver {
    val contentObserver = object : ContentObserver(Handler(Looper.getMainLooper())) {
        override fun onChange(selfChange: Boolean) {
            observer(selfChange)
        }
    }
    registerContentObserver(uri, true, contentObserver)
    return contentObserver
}

fun Context.sendFeedbackEmail() {

    val subject = getString(R.string.feedback_subject)

    val uriBuilder = StringBuilder("mailto:" + Uri.encode(getString(R.string.feedback_email)))
    uriBuilder.append("?subject=" + Uri.encode(subject))
    val uriString = uriBuilder.toString()

    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse(uriString))

    try {
        this.startActivity(intent)
    } catch (e: Exception) {
        Log.e("TAG", "sendFeedbackEmail: ${e.printStackTrace()}")

        // If there is no email client application, than show error message for the user.
        if (e is ActivityNotFoundException) {
            Toast.makeText(
                this,
                "No application can handle this request. Please install an email client app.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}

fun Context.privacyPolicy() {
    val uri = Uri.parse(getString(R.string.privacy_policy_url))
    val intent = Intent(Intent.ACTION_VIEW, uri)
    startActivity(intent)
}

@SuppressLint("RestrictedApi")
fun openMenuItems(
    context: Context,
    view: View,
    listener: PopupMenu.OnMenuItemClickListener,
) {
    try {
        val wrapper = ContextThemeWrapper(context, R.style.ThemePopUpMenu)
        PopupMenu(wrapper, view).apply {
            setOnMenuItemClickListener(listener)
            inflate(R.menu.main_menu_item)
            (menu as MenuBuilder).setOptionalIconsVisible(true)
            show()
        }
    } catch (e: Exception) {
        context.showToast(e.toString())
    }
}

fun Context.hasCameraPermission(): Boolean {
    return EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)
}

fun Context.hasStoragePermission(): Boolean =
    EasyPermissions.hasPermissions(
        this,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
