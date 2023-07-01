package com.example.ex2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class MainViewModel: ViewModel() {

    val editField = MutableLiveData<String>()
}