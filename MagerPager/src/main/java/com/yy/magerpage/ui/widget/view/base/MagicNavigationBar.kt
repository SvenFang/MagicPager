package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.yy.magerpage.R
import com.yy.magerpage.model.widget.base.NavigationBarModel
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.ui.widget.view.AbstractMagic

/**
 * Created by Sven on 17/05/2019
 * 导航栏
 */
class MagicNavigationBar(context: Context) :
    AbstractMagic<NavigationBarModel, RelativeLayout>(context) {

    override fun getContentView(): RelativeLayout {
        val relativeLayout =
            LayoutInflater.from(context).inflate(R.layout.magic_navigationbar, this, false)
        return relativeLayout as RelativeLayout
    }

    override fun analysisDetailData(model: NavigationBarModel) {
        mContentView?.let {
            val bgImg = it.findViewById<ImageView>(R.id.bg_img)
            val llLeft = it.findViewById<LinearLayout>(R.id.ll_left)
            val llRight = it.findViewById<LinearLayout>(R.id.ll_right)
            val llText = it.findViewById<LinearLayout>(R.id.ll_text)

            llLeft.removeAllViews()
            llRight.removeAllViews()
            llText.removeAllViews()

            //背景图片
            model.bgImage?.let { bg ->
                Glide.with(context).asBitmap().load(bg).into(bgImg)
            }

            //左边按钮
            model.left?.let { left ->
                llLeft.addView(MagicViewCreator.createView(left, context))
            }

            //右边按钮
            model.right?.let { right ->
                llRight.addView(MagicViewCreator.createView(right, context))
            }

            llText.removeAllViews()

            //标题
            model.title?.let { title ->
                llText.addView(MagicViewCreator.createView(title, context))
            }

            //副标题
            model.subTitle?.let { title ->
                llText.addView(MagicViewCreator.createView(title, context))
            }
        }
    }
}