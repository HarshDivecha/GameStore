package com.example.practice6.adapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView,url: String?){
    url?.let {
        val uri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(uri)
            .into(imageView)
    }
}