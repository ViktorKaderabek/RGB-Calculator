package com.example.rgb_picker.common

sealed class Resources<T>(val data: T?) {
    class Sucess<T>(data: T?) : Resources<T>(data)
}
