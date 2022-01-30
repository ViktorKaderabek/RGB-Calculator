package com.example.rgb_picker.di

import com.example.rgb_picker.common.Constants
import com.example.rgb_picker.data.remote.ThecolorApi
import com.example.rgb_picker.data.repository.ThecolorRepositoryImpl
import com.example.rgb_picker.domain.repository.ThecolorRepository
import com.example.rgb_picker.domain.use_case.GetColorUseCase
import com.example.rgb_picker.presentation.Color_Detail.ColorDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {

    fun provideRepository(api: ThecolorApi): ThecolorRepository {
        return ThecolorRepositoryImpl(api)
    }

    fun getRetrofitRequest(): ThecolorApi {
        return Retrofit.Builder()
            .baseUrl(Constants.THECOLORAPI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ThecolorApi::class.java)

    }

    fun getDeatilUseCase(repository: ThecolorRepository): GetColorUseCase {
        return GetColorUseCase(repository)
    }

    single { getDeatilUseCase(get()) }
    single { provideRepository(get()) }
    single { getRetrofitRequest() }

}

val colorDetailViewModel = module {
    viewModel{
        ColorDetailViewModel(get())
    }
}