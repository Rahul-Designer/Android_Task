package com.example.androidtask.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.androidtask.JsonApplication
import com.example.androidtask.R
import com.example.androidtask.databinding.FragmentBodyResponseBinding
import com.example.randomquote_retrofit_example.viewModel.MainViewModel
import com.example.randomquote_retrofit_example.viewModel.MainViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class BodyResponseFragment : Fragment() {
    private lateinit var binding: FragmentBodyResponseBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_body_response, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = (activity?.application as JsonApplication).jsonRepository
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
        val bundle = arguments
        val pos = bundle!!.getString("position")!!.toInt()
        mainViewModel.json.observe(viewLifecycleOwner, Observer {
           binding.bodyTxt.text = it[pos].body.toString()
        })
    }
}