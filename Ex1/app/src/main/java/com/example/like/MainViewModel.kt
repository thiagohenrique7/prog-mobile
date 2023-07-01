package com.example.likeexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var likesProgress = 0
    private var likes = 1
    private var completed = false

    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String>
        get() = _nome

    private val _sobrenome = MutableLiveData<String>()
    val sobrenome: LiveData<String>
        get() = _sobrenome

    private val _likeCounter = MutableLiveData<String>()
    val likeCounter: LiveData<String>
        get() = _likeCounter

    private val _likeProgress = MutableLiveData<Int>()
    val likeProgress: LiveData<Int>
        get() = _likeProgress

    private val _image = MutableLiveData<Int>()
    val imageSrc: LiveData<Int>
        get() = _image

    init {
        _likeCounter.value = likes.toString()
        _image.value = R.drawable.like

    }

    fun like() {
        _likeCounter.value = (++likes).toString()

        if(!completed) {
            likesProgress += 10
            _likeProgress.value = (likesProgress)
        }

        if (likes == 3 ) {
            _image.value = R.drawable.heart

        }
        else if(likes == 11) {
            _image.value = R.drawable.fire
            completed = true
        }
        _nome.value = " "
        _sobrenome.value = " "
    }



}