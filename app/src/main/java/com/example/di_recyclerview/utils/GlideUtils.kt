package com.example.di_recyclerview.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.di_recyclerview.MainApplication
import com.example.di_recyclerview.R
import java.io.File

object GlideUtils {

    fun loadImageCircleProfile(view: ImageView?, file: File?, w: Int, h: Int) {
        view?.let {
            Glide.with(MainApplication.INSTANCE)
                .load(file)
                .apply(
                    RequestOptions()
                        .circleCrop()
                        .override(w, h)
                        .skipMemoryCache(false)
                        .placeholder(R.color.Success_Dark)
                        .error(R.color.Alert_Dark)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(it)
        }
    }


    fun loadImageCircleProfile(view: ImageView?, url: String?, w: Int, h: Int) {
        view?.let {
            Glide.with(MainApplication.INSTANCE)
                .load(url)
                .apply(
                    RequestOptions()
                        .circleCrop()
                        .override(w, h)
                        .skipMemoryCache(false)
                        .placeholder(R.color.Success_Dark)
                        .error(R.color.Alert_Dark)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(it)
        }
    }

    fun loadImage(view: ImageView?, url: String?) {
        view?.let {
            Glide.with(MainApplication.INSTANCE)
                .load(url)
                .apply(
                    RequestOptions()
                        .placeholder(R.color.Success_Dark)
                        .error(R.color.Alert_Dark)
                       // .override(w, h)
                        .skipMemoryCache(false)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(it)
        }
    }
}