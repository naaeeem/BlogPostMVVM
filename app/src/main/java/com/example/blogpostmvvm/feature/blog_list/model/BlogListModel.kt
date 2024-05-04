package com.example.blogpostmvvm.feature.blog_list.model

interface BlogListModel {
    fun getBlogList(callback: ModelCallback)
}