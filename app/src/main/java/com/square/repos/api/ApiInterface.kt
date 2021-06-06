package com.square.repos.api

import com.square.repos.model.Repo
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("orgs/square/repos")
    fun getSquareRepos(): Call<List<Repo>?>
}