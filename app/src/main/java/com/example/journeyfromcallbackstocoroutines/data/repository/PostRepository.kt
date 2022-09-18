package com.example.journeyfromcallbackstocoroutines.data.repository

import com.example.journeyfromcallbackstocoroutines.data.remote.APIsInterface

class PostRepository(var apiClient : APIsInterface) {
    fun getAllPosts() = apiClient.getPosts()
}