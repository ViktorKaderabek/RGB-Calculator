package com.example.rgb_picker.presentation.Color_Detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rgb_picker.common.Resources
import com.example.rgb_picker.domain.use_case.GetColorUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ColorDetailViewModel(
    private val use_case : GetColorUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ColorDetailViewModelState())
    val state : State<ColorDetailViewModelState> = _state
    private var r : String? = null
    private var g : String? = null
    private var b : String? = null
    private val rgbColor : String = "id?rgb=${r},${g},${b}"

    init {
        getColorsByRgb(rgbColor)
    }

    private fun getColorsByRgb(rgbColor : String) {
        use_case(rgbColor).onEach { result ->
            when(result){
                is Resources.Sucess -> {
                    _state.value = ColorDetailViewModelState(colorDetail = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}