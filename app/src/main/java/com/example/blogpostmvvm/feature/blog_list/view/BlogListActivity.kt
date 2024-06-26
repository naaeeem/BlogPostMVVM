package com.example.blogpostmvvm.feature.blog_list.view

import com.example.blogpostmvvm.databinding.ActivityBlogListBinding
import com.example.blogpostmvvm.feature.blog_list.view_model.BlogListViewModel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager

class BlogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogListBinding
    private val viewModel: BlogListViewModel by viewModels { BlogListViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getBlogList()

        viewModel.showLoaderLiveData.observe(this) {
            binding.progressBar.isVisible = it ?: false
        }

        viewModel.blogListUiModelLiveData.observe(this) {
            val layoutManager = LinearLayoutManager(this)
            binding.recyclerView.layoutManager = layoutManager

            val adapter = BlogPostRecyclerViewAdapter(it)
            binding.recyclerView.adapter = adapter
        }

        viewModel.showErrorLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

    }
}