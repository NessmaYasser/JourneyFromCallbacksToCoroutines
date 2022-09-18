package com.example.journeyfromcallbackstocoroutines.data.remote

import com.example.journeyfromcallbackstocoroutines.pojo.Post
import retrofit2.Call
import retrofit2.http.GET

interface APIsInterface {

    @GET(ALL_POSTS)
    fun getPosts(): Call<List<Post>>

}