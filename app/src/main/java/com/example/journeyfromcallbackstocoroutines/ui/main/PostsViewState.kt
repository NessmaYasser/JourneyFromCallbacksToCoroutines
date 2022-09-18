package com.example.journeyfromcallbackstocoroutines.ui.main

import com.example.journeyfromcallbackstocoroutines.pojo.Post

data class PostsViewState(
    var posts : List<Post>? = null,
    var loading : Boolean = false,
    var error : String? = null
)
