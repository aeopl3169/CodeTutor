package com.shashi.codetutor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var counter = MutableLiveData<Int>(0)

    var increaseCount = {
        counter.value?.plus(1)
    }

    var decreaseCount = {
        counter.value?.minus(1)
    }
}