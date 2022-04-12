package com.futuretech.pdfreaderconverter.ui.base

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.futuretech.pdfreaderconverter.data.viewmodel.ImageQueueViewModel
import com.futuretech.pdfreaderconverter.utility.Constants
import com.futuretech.pdfreaderconverter.utility.Logger
import pub.devrel.easypermissions.EasyPermissions

open class BaseFragment() : Fragment() {

    val imageQueueViewModel: ImageQueueViewModel by viewModels()

    fun navigate(actionId: Int) {
        findNavController().navigate(actionId)
    }

    fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                Constants.STORAGE_PERMISSION,
                Constants.REQUEST_WRITE_PERMISSION
            )
        }
    }

    private fun displayNeverAskAgainDialog() {

        //If User was asked permission before and denied
        //If User was asked permission before and denied
        val alertDialogBuilder = AlertDialog.Builder(requireContext())

        alertDialogBuilder.setTitle("Permission needed")
        alertDialogBuilder.setMessage("Storage permission needed")
        alertDialogBuilder.setPositiveButton("Open Setting"
        ) { _, _ ->
            val intent = Intent()
            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            val uri = Uri.fromParts("package", requireContext().packageName,
                null)
            intent.data = uri
            startActivity(intent)
        }
        alertDialogBuilder.setNegativeButton("Cancel"
        ) { _, _ -> Logger.debug("dialogInterface=>", "onClick: Cancelling") }

        val dialog = alertDialogBuilder.create()
        dialog.show()

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.isNotEmpty()) {
            if (requestCode == Constants.REQUEST_WRITE_PERMISSION) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
//                    showToast("Permission Granted...")
                } else {
                    // permission denied
                    setShouldShowStatus(requireContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    checkUserRequestedDontAskAgain()
                }
            }
        }

    }

    private fun checkUserRequestedDontAskAgain() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val rationalFalgREAD =
                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)
            val rationalFalgWRITE =
                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)
            if (!rationalFalgREAD && !rationalFalgWRITE) {
                displayNeverAskAgainDialog()
            }
        }
    }

    private fun setShouldShowStatus(context: Context, permission: String?) {
        val genPrefs: SharedPreferences =
            context.getSharedPreferences("GENERIC_PREFERENCES", Context.MODE_PRIVATE)
        val editor = genPrefs.edit()
        editor.putBoolean(permission, true)
        editor.apply()
    }

    fun Context.hasStoragePermission(): Boolean =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else {
            EasyPermissions.hasPermissions(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }

    fun getRatinaleDisplayStatus(context: Context, permission: String?): Boolean {
        val genPrefs: SharedPreferences =
            context.getSharedPreferences("GENERIC_PREFERENCES", Context.MODE_PRIVATE)
        return genPrefs.getBoolean(permission, false)
    }
}
