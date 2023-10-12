package com.shashi.codetutor

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var counter = MutableLiveData<Int>(0)

    var increaseCount = {
        counter.value = counter.value!! +1
        Log.i("shashil", "increment: ${counter.value}")
    }

    var decreaseCount = {
        counter.value = counter.value!! - 1
        Log.i("shashil", "decrement: ${counter.value}")
    }
}