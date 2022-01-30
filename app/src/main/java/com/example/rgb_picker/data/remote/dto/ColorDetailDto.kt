package com.example.rgb_picker.data.remote.dto

import androidx.compose.ui.graphics.Color
import com.example.rgb_picker.domain.model.ColorModel

data class ColorDetailDto(
    val XYZ: XYZ,
    val _embedded: Embedded,
    val _links: Links,
    val cmyk: Cmyk,
    val contrast: Contrast,
    val hex: Hex,
    val hsl: Hsl,
    val hsv: Hsv,
    val image: Image,
    val name: Name,
    val rgb: Rgb
)

fun ColorDetailDto.toColor() : ColorModel {
    return ColorModel(
        cmyk = cmyk,
        hex = hex,
        image = image,
        name = name,
        rgb = rgb
    )
}

