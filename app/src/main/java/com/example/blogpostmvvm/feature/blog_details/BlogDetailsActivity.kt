package com.example.blogpostmvvm.feature.blog_details

import com.bumptech.glide.Glide
import com.example.blogpostmvvm.databinding.ActivityBlogDetailsBinding
import com.example.blogpostmvvm.feature.blog_list.model.data.BlogItemUiModel

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class BlogDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogDetailsBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blogResponse = intent.getSerializableExtra("blog") as BlogItemUiModel

        Glide.with(binding.imageViewFeatured)
            .load(blogResponse.imageUrl)
            .into(binding.imageViewFeatured)

        binding.textViewTitle.text = blogResponse.title
        binding.textViewDate.text = blogResponse.date
        binding.textViewExcerpt.text =
            Html.fromHtml(blogResponse.excerpt, Html.FROM_HTML_MODE_COMPACT)
        binding.textViewContent.text =
            Html.fromHtml(blogResponse.content, Html.FROM_HTML_MODE_COMPACT)
    }
}