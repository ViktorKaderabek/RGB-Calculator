package com.example.rgb_picker.data.repository

import com.example.rgb_picker.data.remote.ThecolorApi
import com.example.rgb_picker.data.remote.dto.ColorDetailDto
import com.example.rgb_picker.domain.repository.ThecolorRepository

class ThecolorRepositoryImpl(
    private val api : ThecolorApi
) : ThecolorRepository {

    override suspend fun getCoinsByRgb(rgbColor: String): ColorDetailDto {
        return api.getCoinsByRgb(rgbColor)
    }
}