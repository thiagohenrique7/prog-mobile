package com.example.likeexercise

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadWithPicasso")
fun loadWithPicasso(imageView: ImageView, imageUrl: Int) {
    Picasso.get().load(imageUrl).into(imageView)
}