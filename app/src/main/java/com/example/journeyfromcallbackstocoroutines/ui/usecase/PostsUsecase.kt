package com.example.journeyfromcallbackstocoroutines.ui.usecase

import com.example.journeyfromcallbackstocoroutines.data.repository.PostRepository

class PostsUsecase(var repository: PostRepository) {

    fun getAllPosts() = repository.getAllPosts()
}