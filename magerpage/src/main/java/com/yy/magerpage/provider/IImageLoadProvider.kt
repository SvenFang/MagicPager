package com.yy.magerpage.provider

import android.widget.ImageView

/**
 * Created by Sven on 2019-07-19
 */
interface IImageLoadProvider {
    fun loadImage(imageView: ImageView, url: String)
}
