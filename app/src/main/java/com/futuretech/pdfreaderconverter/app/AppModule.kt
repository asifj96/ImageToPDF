package com.futuretech.pdfreaderconverter.app

import com.futuretech.pdfreaderconverter.remote.RemoteConfigViewModel
import com.futuretech.pdfreaderconverter.remote.RemoteDataClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    val allModules = module {
        single { RemoteDataClient().init(get()) }

    }
    val viewModelModule = module {
        viewModel { RemoteConfigViewModel(get()) }
    }
}