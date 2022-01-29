package com.example.rgb_picker.di

import com.example.rgb_picker.presentation.Color_Detail.ColorDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

}

val colorDetailViewModel = module {
    viewModel{
        ColorDetailViewModel()
    }
}