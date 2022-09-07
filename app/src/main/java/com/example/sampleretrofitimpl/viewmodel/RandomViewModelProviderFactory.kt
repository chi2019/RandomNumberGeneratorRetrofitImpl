package com.example.sampleretrofitimpl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampleretrofitimpl.network.service.repository.RandomNumberRepo

class RandomViewModelProviderFactory(val randomNumberRepo: RandomNumberRepo): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RandomNumberViewModel(randomNumberRepo) as T
    }

}