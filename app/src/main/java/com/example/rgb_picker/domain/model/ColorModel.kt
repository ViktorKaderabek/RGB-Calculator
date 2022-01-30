package com.example.rgb_picker.domain.model

import com.example.rgb_picker.data.remote.dto.*

data class ColorModel(
    val cmyk: Cmyk,
    val hex: Hex,
    val image: Image,
    val name: Name,
    val rgb: Rgb
)