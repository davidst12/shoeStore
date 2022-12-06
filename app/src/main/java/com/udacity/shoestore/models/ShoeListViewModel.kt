package com.udacity.shoestore.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ShoeListViewModel: ViewModel(){

    var shoeList = ArrayList<Shoe>()

    private val _eventInsertNewShoe = MutableLiveData<Boolean>()
    val eventInsertNewShoe: LiveData<Boolean>
        get() = _eventInsertNewShoe

    init {
        _eventInsertNewShoe.value = false
    }

    fun addShoe(shoeItem: Shoe){
        shoeList.add(shoeItem)
    }

    fun onInsertNewShoe(){
        _eventInsertNewShoe.value = true
    }

    fun onButtonPressedComplete(){
        _eventInsertNewShoe.value = false
    }
}