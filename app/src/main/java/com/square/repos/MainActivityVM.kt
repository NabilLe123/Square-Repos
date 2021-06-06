package com.square.repos

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.square.repos.api.ApiClient
import com.square.repos.model.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityVM : ViewModel() {
    var isLoading = ObservableBoolean(true)
    val repos = MutableLiveData<List<Repo>>()
    val errorData = MutableLiveData<Throwable>()

    fun loadRepos() {
        val call: Call<List<Repo>?> = ApiClient.getApiInterface().getSquareRepos()
        call.enqueue(object : Callback<List<Repo>?> {
            override fun onResponse(
                call: Call<List<Repo>?>,
                response: Response<List<Repo>?>
            ) {
                loadingFinish()

                if (response.code() == 200 && response.body() != null) {
                    Log.d("square_repo", "repos: " + response.body()!!.size)
                    repos.value = response.body()!!

                } else {
                    Log.d("square_repo", "repos: null")
                    repos.value = ArrayList()

                }
            }

            override fun onFailure(call: Call<List<Repo>?>, t: Throwable) {
                loadingFinish()
                Log.d("square_repo", "repos: " + t.message)
                errorData.value = t

            }
        })
    }

    private fun loadingFinish() {
        isLoading.set(false)
    }
}