package com.silvacomp.sensors

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel() {
    private val _valueAccelerometer = mutableStateOf<String>("")
    val valueAccelerometer: State<String> =_valueAccelerometer


    fun onChangedValue(value: String?){
        _valueAccelerometer.value = value?:"no values"
    }



}