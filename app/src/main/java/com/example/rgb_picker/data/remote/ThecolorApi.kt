package com.example.rgb_picker.data.remote

import com.example.rgb_picker.data.remote.dto.ColorDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ThecolorApi {

    @GET("/{id?rgb=x,x,x}")
    suspend fun getCoinsByRgb(@Path("id?rgb=0,71,171") rgbColor : String) : ColorDetailDto
}