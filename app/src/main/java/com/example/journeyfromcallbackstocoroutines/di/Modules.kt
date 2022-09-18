package com.example.journeyfromcallbackstocoroutines.di

import com.example.journeyfromcallbackstocoroutines.data.remote.ClientServiceFactory
import com.example.journeyfromcallbackstocoroutines.data.remote.baseUrl
import com.example.journeyfromcallbackstocoroutines.data.repository.PostRepository
import com.example.journeyfromcallbackstocoroutines.ui.usecase.PostsUsecase
import com.example.journeyfromcallbackstocoroutines.ui.main.PostsViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    //singleton
    single { ClientServiceFactory(baseUrl).service }
    //repository
    factory { PostRepository(get())}
    //usecase
    factory { PostsUsecase(get()) }
    //viewmodel
    viewModel { PostsViewModel(get()) }
}