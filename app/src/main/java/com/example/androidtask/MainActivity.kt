package com.example.androidtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtask.Adapter.JsonAdapter
import com.example.androidtask.databinding.ActivityMainBinding
import com.example.randomquote_retrofit_example.viewModel.MainViewModel
import com.example.randomquote_retrofit_example.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: JsonAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.jsonRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = JsonAdapter(this)
        binding.jsonRecyclerview.adapter = adapter

        val repository = (application as JsonApplication).jsonRepository

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.json.observe(this, Observer {

            adapter.updateDataList(it)
//            binding.responseTxt.text = it.toString()
//            Log.d("RAHUL", it.toString())
//            adapter.updateUserList(it.results)

        })
    }


}