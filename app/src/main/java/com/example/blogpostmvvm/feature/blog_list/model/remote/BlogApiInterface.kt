package com.example.blogpostmvvm.feature.blog_list.model.remote

import com.example.blogpostmvvm.feature.blog_list.model.data.BlogResponse
import retrofit2.Call
import retrofit2.http.GET

interface BlogApiInterface {

    @GET("posts")
    fun getBlogList() : Call<List<BlogResponse>>
}