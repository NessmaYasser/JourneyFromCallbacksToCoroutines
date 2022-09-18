package com.example.journeyfromcallbackstocoroutines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.journeyfromcallbackstocoroutines.pojo.Post
import com.example.journeyfromcallbackstocoroutines.ui.usecase.PostsUsecase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel(var useCase: PostsUsecase) : ViewModel() {
    private val _postsLiveData = MutableLiveData<PostsViewState>()
    var postsLiveData = _postsLiveData

    fun getPosts() {
        useCase.getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                    _postsLiveData.value = _postsLiveData.value?.copy(
                        posts = response.body() ?: listOf(),
                        loading = false,
                        error = null
                    )
                }else{

                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                _postsLiveData.value = _postsLiveData.value?.copy(
                    posts = null,
                    loading = false,
                    error = t.localizedMessage
                )
            }

        })
    }
}