package com.futuretech.pdfreaderconverter.ui.base

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.futuretech.pdfreaderconverter.data.viewmodel.FileViewModel
import com.futuretech.pdfreaderconverter.data.viewmodel.ImageQueueViewModel

open class BaseActivity : AppCompatActivity() {


    val fileViewModel: FileViewModel by viewModels()
    val imageQueueViewModel: ImageQueueViewModel by viewModels()
}