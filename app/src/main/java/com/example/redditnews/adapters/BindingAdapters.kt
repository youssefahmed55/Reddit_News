package com.example.redditnews.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.redditnews.ui.kotlinNews.KotlinNewsViewStates
import com.facebook.shimmer.ShimmerFrameLayout

@BindingAdapter("imageUrl")
fun bindPictureToImage(image: ImageView, url: String?) {
    if(url!=null)
        if(url.isNotEmpty())
            Glide.with(image.context).load(url).fitCenter().into(image)
}

@BindingAdapter("showShimmerOnLoading")
fun ShimmerFrameLayout.showShimmerOnLoading(states: KotlinNewsViewStates) {
    visibility = if (states == KotlinNewsViewStates.Loading) {
        startShimmer()
        View.VISIBLE
    }else {
        stopShimmer()
        View.GONE
    }
}