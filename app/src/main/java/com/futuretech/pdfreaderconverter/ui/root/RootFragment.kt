package com.futuretech.pdfreaderconverter.ui.root

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.adapter.RootItemAdapter
import com.futuretech.pdfreaderconverter.databinding.FragmentRootBinding
import com.futuretech.pdfreaderconverter.extension.*
import com.futuretech.pdfreaderconverter.model.ImageQueue
import com.futuretech.pdfreaderconverter.ui.base.BaseFragment
import com.futuretech.pdfreaderconverter.ui.camera.CameraScreen
import com.futuretech.pdfreaderconverter.ui.editing.EditImageScreen
import com.futuretech.pdfreaderconverter.ui.gallery.GalleryScreen
import com.futuretech.pdfreaderconverter.ui.home.HomeFiles
import com.futuretech.pdfreaderconverter.utility.Constants.GALLERY_IMAGE
import com.futuretech.pdfreaderconverter.utility.Constants.GALLERY_PICKER_RESULT
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_QUEUE_LIST
import com.futuretech.pdfreaderconverter.utility.FileOperation.getOutputFileDirectory
import com.futuretech.pdfreaderconverter.utility.FileOperation.getRealPathFromURI
import com.futuretech.pdfreaderconverter.utility.Logger
import kotlinx.coroutines.launch
import java.io.File

class RootFragment : BaseFragment(), PopupMenu.OnMenuItemClickListener {

    private var imageQueueObj: ImageQueue? = null
    private var imageQueueArrayList = ArrayList<ImageQueue>()
    private lateinit var mBinding: FragmentRootBinding
    private var rootItemAdapter: RootItemAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_root, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
        setListener()
        setRootItemAdapter()
    }

    private fun setListener() {

        mBinding.toolbar.iVDropDown.setOnClickListener {
            openMenuItems(requireContext(), mBinding.toolbar.iVDropDown, this)
        }
    }

    private fun setToolbar() {
        mBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        mBinding.toolbar.iVDropDown.visibility = View.VISIBLE
        mBinding.toolbar.tvToolbarTitle.text = getString(R.string.title)
    }

    private fun setRootItemAdapter() {

        rootItemAdapter = RootItemAdapter(
            requireActivity().getRootItemArrayList(),
            fun(itemPos: Int) {
                handleClick(itemPos)
            })
        val gridLayoutManager = GridLayoutManager(
            requireContext(), 2, RecyclerView.VERTICAL,
            false
        )
        val spacing = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._6sdp) / 2
        mBinding.rvRootItemList.apply {
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
            layoutManager = GridLayoutManager(context, 2)
        }
        mBinding.rvRootItemList.layoutManager = gridLayoutManager
        mBinding.rvRootItemList.itemAnimator = DefaultItemAnimator()
        mBinding.rvRootItemList.adapter = rootItemAdapter
    }

    private fun handleClick(itemPos: Int) {

        when (itemPos) {

            0 -> {
//                navigate(R.id.action_rootFragment_to_homeFilesFragment)
                startHomeScreen()
            }
            1 -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (Environment.isExternalStorageManager()) {
                        navigate(R.id.action_rootFragment_to_pdfFilesFragment)
                    } else {
                        try {
                            val intent =
                                Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                            intent.addCategory("android.intent.category.DEFAULT")
                            intent.data = Uri.parse(
                                String.format(
                                    "package:%s",
                                    requireContext().applicationContext.packageName
                                )
                            )
                            startActivity(intent)
                        } catch (e: java.lang.Exception) {
                            val intent = Intent()
                            intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                            startActivity(intent)
                        }
                    }
                } else {
                    if (!requireContext().hasStoragePermission()) {
                        requestPermission()
                    } else {
                        navigate(R.id.action_rootFragment_to_pdfFilesFragment)
                    }
                }
            }
            2 -> {
                if (requireContext().hasStoragePermission()) {
                    startCameraScreen()
                } else {
                    requestPermission()
                }
            }
            3 -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (Environment.isExternalStorageManager()) {
                        startGalleryScreen()
                    } else {
                        try {
                            val intent =
                                Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                            intent.addCategory("android.intent.category.DEFAULT")
                            intent.data = Uri.parse(
                                String.format(
                                    "package:%s",
                                    requireContext().applicationContext.packageName
                                )
                            )
                            startActivity(intent)
                        } catch (e: java.lang.Exception) {
                            val intent = Intent()
                            intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                            startActivity(intent)
                        }
                    }
                } else {
                    if (!requireContext().hasStoragePermission()) {
                        requestPermission()
                    } else {
                        startGalleryScreen()
                    }
                }
            }
        }
    }

    private fun startGalleryScreen() {
        val intent = Intent(requireContext(), GalleryScreen::class.java)
//        startActivity(intent)
        galleryLauncher.launch(intent)
        requireActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    private fun startCameraScreen() {
        val intent = Intent(requireContext(), CameraScreen::class.java)
        startActivity(intent)
        requireActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    private fun startHomeScreen() {
        val intent = Intent(requireContext(), HomeFiles::class.java)
        startActivity(intent)
        requireActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.share_app -> {
                requireContext().shareApp()
            }
            R.id.rate_this_app -> {
                requireContext().rateUs(context)
            }
            R.id.give_feedback -> {
                requireActivity().sendFeedbackEmail()
            }
            R.id.privacy_policy -> {
                requireActivity().privacyPolicy()
            }
        }
        return true
    }

    @SuppressLint("LogNotTimber")
    var galleryLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

        if (it.resultCode == GALLERY_PICKER_RESULT) {
            val intent: Intent? = it.data
            if (intent != null) {
                val uriImagesList = intent.getSerializableExtra(
                    GALLERY_IMAGE
                )
                Log.d("ImagesList::", "setupListeners: images -> $uriImagesList")
                val outputDirectory =
                    requireContext().getOutputFileDirectory(resources.getString(R.string.app_name))
                Logger.debug("DIRECTORY", outputDirectory.toString())
                for ((i, element) in (uriImagesList as ArrayList<*>).withIndex()) {
                    val srcFile = File(requireContext().getRealPathFromURI(element as Uri))
                    val destFile =
                        File(
                            outputDirectory,
                            getCurrentTimeStamp() + i.toString() + srcFile.name
                        )

                    if (srcFile.exists()) {
                        srcFile.copyTo(
                            target = destFile,
                            overwrite = true,
                            bufferSize = DEFAULT_BUFFER_SIZE
                        )
                    }
                    setImageQueueData(destFile.absolutePath)
                }

                startEditImageScreen()
            }
        }
    }

    private fun startEditImageScreen() {

        deleteQueueImage()
        val intent = Intent(requireContext(), EditImageScreen::class.java)
        val tempImageQueueList: ArrayList<ImageQueue> = ArrayList()
        tempImageQueueList.addAll(imageQueueArrayList)
        imageQueueArrayList.remove(imageQueueObj)
        imageQueueArrayList = ArrayList()
        imageQueueArrayList.clear()
        intent.putExtra(IMAGE_QUEUE_LIST, tempImageQueueList)
        startActivity(intent)
        requireActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    private fun setImageQueueData(path: String?) {

        imageQueueObj = ImageQueue(path)
        imageQueueArrayList.add(
            imageQueueObj!!
        )
        lifecycleScope.launch {
            imageQueueViewModel.insertQueueImage(imageQueueObj!!)
        }
    }

    private fun deleteQueueImage() {

        lifecycleScope.launch {

            imageQueueViewModel.deleteAllQueueImages()
        }
    }
    /*  private fun checkPermission() {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
              if (Environment.isExternalStorageManager()) {
                  navigate(R.id.action_permissionFragment_to_homeFragment)
              } else {
                  try {
                      val intent =
                          Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                      intent.addCategory("android.intent.category.DEFAULT")
                      intent.data = Uri.parse(String.format("package:%s",
                          requireContext().packageName))
                      startActivity(intent)
                  } catch (e: Exception) {
                      val intent = Intent()
                      intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                      startActivity(intent)
                  }
              }
          } else {
              if (!requireContext().hasStoragePermission()) {
                  requestPermission()
              } else {
                  navigate(R.id.action_permissionFragment_to_homeFragment)
              }
          }
      }*/
}