package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.yy.magerpage.model.modelenum.ScaleType
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.ui.widget.view.MagicViewHelper

/**
 * Created by Sven on 17/05/2019
 */
class MagicImage(context: Context) : IMagic<ImageWidgetModel, ImageView>(context) {

    override fun getContentView(): ImageView {
        return ImageView(context)
    }

    override fun analysisDetailData(model: ImageWidgetModel) {

        when (model.scaleType) {
            ScaleType.INSIDE -> mContentView?.scaleType = ImageView.ScaleType.CENTER_INSIDE
            ScaleType.CROP -> mContentView?.scaleType = ImageView.ScaleType.CENTER_CROP
            ScaleType.FIX -> mContentView?.scaleType = ImageView.ScaleType.FIT_XY
        }


        if (null != model.imgSrc) {
            Glide.with(this).load(model.imgSrc).into(mContentView!!)
        } else if (null != model.imgRes) {
            Glide.with(this).load(model.imgRes).into(mContentView!!)
        }
    }
}