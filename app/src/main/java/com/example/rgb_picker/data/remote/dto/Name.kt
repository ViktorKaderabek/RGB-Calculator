package com.example.rgb_picker.data.remote.dto

data class Name(
    val closest_named_hex: String,
    val distance: Int,
    val exact_match_name: Boolean,
    val value: String
)