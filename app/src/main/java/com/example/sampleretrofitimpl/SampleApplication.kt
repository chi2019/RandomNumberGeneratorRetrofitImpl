package com.example.sampleretrofitimpl

import android.app.Application
import com.example.sampleretrofitimpl.network.service.RandomNumberService
import com.example.sampleretrofitimpl.network.service.repository.RandomNumberRepo
import com.example.sampleretrofitimpl.network.service.repository.RandomNumberRepoImpl
import com.example.sampleretrofitimpl.viewmodel.RandomViewModelProviderFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class SampleApplication :Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@SampleApplication))

        bind() from singleton { RandomNumberService.createService() }
        bind() from provider { RandomNumberRepoImpl(instance()) }
        bind() from provider { RandomViewModelProviderFactory(instance()) }

    }

    override fun onCreate() {
        super.onCreate()
    }
}