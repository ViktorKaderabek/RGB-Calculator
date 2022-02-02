package com.example.rgb_picker.data.remote

import com.example.rgb_picker.data.remote.dto.ColorDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ThecolorApi {

    @GET("/id")
    suspend fun getCoinsByRgb(@Query("rgb") rgb : String) : ColorDetailDto
}