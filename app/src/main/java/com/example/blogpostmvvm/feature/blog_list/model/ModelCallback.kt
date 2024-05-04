package com.example.blogpostmvvm.feature.blog_list.model

import com.example.blogpostmvvm.feature.blog_list.model.data.BlogResponse

interface ModelCallback {
    fun onSuccess(list: List<BlogResponse>)
    fun onError(error: String)
}