package com.example.sampleretrofitimpl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.example.sampleretrofitimpl.databinding.ActivityMainBinding
import com.example.sampleretrofitimpl.viewmodel.RandomNumberViewModel
import com.example.sampleretrofitimpl.viewmodel.RandomViewModelProviderFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(),KodeinAware {

    override val kodein: Kodein by closestKodein()
    lateinit var viewBinding: ActivityMainBinding

    val randomViewModelProviderFactory: RandomViewModelProviderFactory by instance()
    val viewmodelFactory: ViewModelProvider.Factory by lazy { randomViewModelProviderFactory }
    val viewModel: RandomNumberViewModel by lazy { ViewModelProvider(this,viewmodelFactory).get(RandomNumberViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewModel.randomNumberData.observe(this, Observer {
            Log.e("data","${it}")
        })
    }

    override fun onResume() {
        super.onResume()
       viewBinding.textSample.setOnClickListener {
            viewModel.getRandomNumber(100,100,5)
        }

    }

}