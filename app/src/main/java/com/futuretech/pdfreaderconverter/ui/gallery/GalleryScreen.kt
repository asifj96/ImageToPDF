package com.futuretech.pdfreaderconverter.ui.gallery

import android.content.ContentUris
import android.content.Intent
import android.database.Cursor
import android.database.StaleDataException
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.adapter.GalleryAdapter
import com.futuretech.pdfreaderconverter.databinding.ActivityGalleryScreenBinding
import com.futuretech.pdfreaderconverter.extension.disableClick
import com.futuretech.pdfreaderconverter.extension.showToast
import com.futuretech.pdfreaderconverter.model.GalleryModel
import com.futuretech.pdfreaderconverter.ui.camera.CameraScreen
import com.futuretech.pdfreaderconverter.utility.Constants.GALLERY_IMAGE
import com.futuretech.pdfreaderconverter.utility.Constants.GALLERY_PICKER_RESULT
import com.futuretech.pdfreaderconverter.utility.Logger

class GalleryScreen : AppCompatActivity() {
    private val galleryBinding: ActivityGalleryScreenBinding by lazy {

        ActivityGalleryScreenBinding.inflate(layoutInflater)/*.apply {
            rvGalleryItem.layoutManager =
                LinearLayoutManager(this@GalleryScreen, RecyclerView.VERTICAL, false)
            rvGalleryItem.setHasFixedSize(true)
            rvGalleryItem.adapter = galleryImagesAdapter
        }*/
    }
    private var galleryItemArrayList: ArrayList<GalleryModel> = ArrayList()
    private var allFileCursor: Cursor? = null
    private val galleryImagesAdapter: GalleryAdapter by lazy {
        GalleryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(galleryBinding.root)

        getGalleryImages()
        setToolbar()
        setListener()

    }

    private fun setListener() {
        galleryBinding.toolbar.iVBackArrow.setOnClickListener {
            if (disableClick()) {
                finish()
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
        }
        galleryBinding.toolbar.tvApply.setOnClickListener {
            setGalleryData()
        }
    }

    private fun setToolbar() {
        galleryBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        galleryBinding.toolbar.iVBackArrow.visibility = View.VISIBLE
        galleryBinding.toolbar.tvApply.visibility = View.VISIBLE
        galleryBinding.toolbar.tvToolbarTitle.isSelected = true
        galleryBinding.toolbar.tvToolbarTitle.text = resources.getString(R.string.gallery_picker)
    }

    private fun setGalleryData() {
        val uriImages =
            galleryImagesAdapter.currentList.filter { it.isSelected }
                .map { it.uri }
        if (!uriImages.isNullOrEmpty()) {
            val intent = Intent(applicationContext, CameraScreen::class.java)
            intent.putParcelableArrayListExtra(GALLERY_IMAGE, uriImages as ArrayList<Uri>)
            setResult(GALLERY_PICKER_RESULT, intent)
            finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        } else {

            showToast(resources.getString(R.string.please_select_image))
        }

        Logger.debug("TAG", "setupListeners: images -> $uriImages")
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    private fun getGalleryImages() {

        galleryItemArrayList = ArrayList()
        var projection = arrayOf(
            MediaStore.Images.ImageColumns._ID,
            MediaStore.Images.ImageColumns.DATE_MODIFIED,
            MediaStore.Images.ImageColumns.SIZE,
        )

        val uri = MediaStore.Images.Media.getContentUri("external")
        projection += MediaStore.Images.ImageColumns.DATA

        val idCol = MediaStore.Images.ImageColumns._ID
        val sortOrder = "${MediaStore.Images.Media.DATE_MODIFIED} DESC"
        val sizeCol = MediaStore.Images.ImageColumns.SIZE
        allFileCursor = contentResolver
            .query(uri, projection, null, null, sortOrder)

        try {
            if (allFileCursor != null) {
                if (allFileCursor!!.count >= 0) {
                    if (allFileCursor!!.moveToFirst()) {
                        do {
                            val id =
                                allFileCursor?.getInt(allFileCursor?.getColumnIndexOrThrow(idCol)!!)
                            val date = allFileCursor?.getLong(
                                allFileCursor?.getColumnIndexOrThrow(
                                    MediaStore.MediaColumns.DATE_MODIFIED
                                )!!
                            )
                            val size =
                                allFileCursor?.getLong(allFileCursor?.getColumnIndexOrThrow(sizeCol)!!)

                            val pathCol =
                                allFileCursor!!.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATA)

                            val path = allFileCursor?.getString(pathCol)
                            val fileUri = ContentUris.withAppendedId(uri, id?.toLong()!!)
                            galleryItemArrayList.add(
                                GalleryModel(
                                    id,
                                    date!!,
                                    size!!,
                                    fileUri,
                                    path!!
                                )
                            )
                        } while (allFileCursor?.moveToNext()!!)
                    }
                }
                allFileCursor?.close()
                try {
                    setGalleryAdapter()

                } catch (e: IllegalStateException) {
                    e.printStackTrace()
                }
            }
        } catch (e: StaleDataException) {
            e.printStackTrace()
        } finally {
            allFileCursor!!.close()
        }
    }

    private fun setGalleryAdapter() {
        if (galleryItemArrayList.size == 0) {
            galleryBinding.cLNoItem.visibility = View.VISIBLE
        } else {

            val gridLayoutManager = GridLayoutManager(this, 3)
            galleryBinding.rvGalleryItem.layoutManager = gridLayoutManager
            galleryBinding.rvGalleryItem.itemAnimator = DefaultItemAnimator()
            galleryBinding.rvGalleryItem.adapter = galleryImagesAdapter
            galleryImagesAdapter.submitList(galleryItemArrayList)
            val spacing = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._4sdp) / 2
            galleryBinding.rvGalleryItem.apply {
                setHasFixedSize(true)
                addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(
                        rect: Rect,
                        view: View,
                        parent: RecyclerView,
                        state: RecyclerView.State,
                    ) {
                        rect.set(spacing, spacing, spacing, spacing)
                    }
                })
                layoutManager = GridLayoutManager(context, 3)
            }
        }
    }
}