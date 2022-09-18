package com.example.journeyfromcallbackstocoroutines.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.journeyfromcallbackstocoroutines.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val postsViewModel: PostsViewModel by viewModel()
    var postAdapter = PostAdapter()
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        setupView()

        postsViewModel.postsLiveData.observe(this, Observer {
            renderViewState(it)
        })
    }

    fun renderViewState(viewState: PostsViewState) {
        if (viewState.loading) {

        } else {

        }

        if (!viewState.posts.isNullOrEmpty()) {
            postAdapter.submitList(viewState.posts)

        }

        if(viewState.error != null){

        }
    }

    fun setupView() {
        
        postsViewModel.getPosts()

        bind.timelineRV.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}