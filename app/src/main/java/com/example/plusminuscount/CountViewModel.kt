package com.example.plusminuscount

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private val _count = MutableLiveData<Int>() //Mutable = create a new one, and delete previous one

    val count: LiveData<Int>
        get() = _count

    init {
        _count.value = 0
        Log.d("ViewModel", "ViewModel initialized")
    }

    fun increment(){
        _count.value = _count.value?.plus(1)
    }

    fun decrement(){
        _count.value = _count.value?.minus(1)
    }

    override fun onCleared() {
        Log.d("ViewModel", "ViewModel initialized")
        super.onCleared()
    }
}