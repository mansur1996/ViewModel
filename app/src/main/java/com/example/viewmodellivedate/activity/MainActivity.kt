package com.example.viewmodellivedate.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodellivedate.MainViewModel
import com.example.viewmodellivedate.adapter.UserAdapter
import com.example.viewmodellivedate.databinding.ActivityMainBinding
import com.example.viewmodellivedate.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var users : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        users = ArrayList()
        initView()
    }

    private fun initView() {
        mainViewModel.getUsers().observe(this){
            it.forEach {
                users.add(it)
            }
            refreshAdapter(users)
        }
    }

    private fun refreshAdapter(list: List<User>) {
        val adapter = UserAdapter(list)
        binding.rv.adapter = adapter

    }
}