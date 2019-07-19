package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.R
import com.yy.magerpage.model.widget.base.NavigationBarModel
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.ui.widget.view.MagicViewHelper

/**
 * Created by Sven on 17/05/2019
 */
class MagicNavigationBar(context: Context) :
    IMagic<NavigationBarModel, RelativeLayout>(context) {

    override fun getContentView(): RelativeLayout {
        val relativeLayout = LayoutInflater.from(context).inflate(R.layout.magic_navigationbar, this, false)
        return relativeLayout as RelativeLayout
    }

    override fun analysisDetailData(model: NavigationBarModel) {
        mContentView?.let {
            val bgImg = it.findViewById<ImageView>(R.id.bg_img)
            val llLeft = it.findViewById<LinearLayout>(R.id.ll_left)
            val llRight = it.findViewById<LinearLayout>(R.id.ll_right)
            val llText = it.findViewById<LinearLayout>(R.id.ll_text)

            //背景图片
            model.bgImage?.let { bg ->
                MagicPagerManager.get().imageProvider?.loadImage(bgImg, bg)
            }

            //左边按钮
            model.left?.let { left ->
                llLeft.addView(MagicViewHelper.createView(left, context))
            }

            //右边按钮
            model.right?.let { right ->
                llRight.addView(MagicViewHelper.createView(right, context))
            }

            //标题
            model.title?.let { title ->
                llText.addView(MagicViewHelper.createView(title, context))
            }

            //副标题
            model.subTitle?.let { title ->
                llText.addView(MagicViewHelper.createView(title, context))
            }
        }
    }
}