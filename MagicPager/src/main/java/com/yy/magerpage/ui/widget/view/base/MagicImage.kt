package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.Target
import com.yy.magerpage.model.modelenum.ScaleType
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.ui.widget.view.AbstractMagic
import com.yy.magerpage.util.LengthUtil

/**
 * Created by Sven on 17/05/2019
 * 图片view
 */
class MagicImage(context: Context) : AbstractMagic<ImageWidgetModel, ImageView>(context) {

    override fun getContentView(): ImageView {
        return ImageView(context)
    }

    override fun analysisDetailData(model: ImageWidgetModel) {

        when (model.scaleType) {
            ScaleType.INSIDE -> mContentView?.scaleType = ImageView.ScaleType.CENTER_INSIDE
            ScaleType.CROP -> mContentView?.scaleType = ImageView.ScaleType.CENTER_CROP
            ScaleType.FIX -> mContentView?.scaleType = ImageView.ScaleType.FIT_XY
        }

        if (null != model.imgSrc || null != model.imgRes) {

            var builder = Glide.with(mContentView!!)
                .asBitmap()
                .override(imageLength(model.width), imageLength(model.height))

            val tranforms = ArrayList<BitmapTransformation>()

            if (model.scaleType == ScaleType.CROP) {
                tranforms.add(CenterCrop())
            } else if (model.scaleType == ScaleType.INSIDE) {
                tranforms.add(CenterInside())
            }

            if (model.corner > 0) {
                tranforms.add(RoundedCorners(LengthUtil.length2px(model.corner, context)))
            }

            if (null != model.imgSrc && model.imgSrc!!.isNotEmpty()) {
                builder = builder.load(model.imgSrc)
                if (null != model.imgRes) {
                    var errorBuilder =
                        Glide.with(mContentView!!).asBitmap().load(model.imgRes!!)
                    if (tranforms.size > 0) {
                        errorBuilder =
                            errorBuilder.transform(MultiTransformation(tranforms)).dontAnimate()
                    }
                    builder = builder.error(errorBuilder).dontAnimate()
                }
            } else if (null != model.imgRes) {
                builder = builder.load(model.imgRes)
            }

            if (tranforms.size > 0) {
                builder = builder.transform(MultiTransformation(tranforms))
            }

            builder.into(mContentView!!)
        }
    }

    private fun imageLength(length: Double): Int {
        return if (length > 0) {
            LengthUtil.length2px(length, context)
        } else Target.SIZE_ORIGINAL
    }
}