package com.example.rgb_picker.domain.repository

import com.example.rgb_picker.data.remote.dto.ColorDetailDto

interface ThecolorRepository {

    suspend fun getCoinsByRgb(rgbColor : String) : ColorDetailDto
}