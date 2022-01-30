package com.example.rgb_picker.domain.use_case

import android.util.Log
import com.example.rgb_picker.common.Resources

import com.example.rgb_picker.data.remote.dto.toColor
import com.example.rgb_picker.domain.model.ColorModel
import com.example.rgb_picker.domain.repository.ThecolorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetColorUseCase(
    private val repository : ThecolorRepository
) {
    operator fun invoke(rgbColor: String): Flow<Resources<ColorModel>> = flow {
        try {
            val color = repository.getCoinsByRgb(rgbColor).toColor()
            emit(Resources.Sucess<ColorModel>(color))
        }
        catch (e : Exception){
            Log.e("message", e.toString())
        }
    }
}