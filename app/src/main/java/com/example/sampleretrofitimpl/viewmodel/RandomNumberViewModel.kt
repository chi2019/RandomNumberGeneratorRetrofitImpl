package com.example.sampleretrofitimpl.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleretrofitimpl.network.service.repository.RandomNumberRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RandomNumberViewModel(val randomNumberRepo: RandomNumberRepo):ViewModel() {

    val _randomNumberData = MutableLiveData<List<Int>?>()
    val randomNumberData = _randomNumberData

    val stateFlow = MutableStateFlow(false)


    fun getRandomNumber(min:Int, max:Int, count:Int){
        viewModelScope.launch {

            val result = kotlin.runCatching { randomNumberRepo.getRandomNumber(min,max,count) }

            result.onSuccess {
                _randomNumberData.postValue(it)
            }
            result.onFailure {
                _randomNumberData.postValue(null)
            }

            stateFlow.update { it ->
               !it
            }


        }
    }

}