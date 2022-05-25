package com.example.viewmodellivedate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodellivedate.model.User
import com.example.viewmodellivedate.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var liveData = MutableLiveData<List<User>>()
    private val TAG = "MyLiveData"

    fun getUsers() : LiveData<List<User>> {
        ApiClient.apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful){
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
        return liveData
    }
}