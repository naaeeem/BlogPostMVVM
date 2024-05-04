package com.example.blogpostmvvm.feature.blog_list.model

import com.example.blogpostmvvm.feature.blog_list.model.data.BlogResponse
import com.example.blogpostmvvm.feature.blog_list.model.remote.BlogApiInterface
import com.example.blogpostmvvm.feature.network.RetrofitClient

import retrofit2.*

class BlogListModelImpl : BlogListModel {
    private val blogApiInterface = RetrofitClient.client.create<BlogApiInterface>()

    override fun getBlogList(callback: ModelCallback) {
        val apiCall = blogApiInterface.getBlogList()

        apiCall.enqueue(object : Callback<List<BlogResponse>> {
            override fun onResponse(
                call: Call<List<BlogResponse>>, response: Response<List<BlogResponse>>
            ) {
                val blogList = response.body()
                if (blogList?.isEmpty() == true) {
                    callback.onError("content not found")
                } else {
                    callback.onSuccess(blogList!!)
                }
            }

            override fun onFailure(call: Call<List<BlogResponse>>, t: Throwable) {
                callback.onError(t.message ?: "Something went wrong!")
            }

        })
    }
}