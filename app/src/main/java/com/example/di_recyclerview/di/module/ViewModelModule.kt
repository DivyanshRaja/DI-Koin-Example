package com.example.di_recyclerview.di.module

import com.example.di_recyclerview.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        MainViewModel(get(),get())
    }
}