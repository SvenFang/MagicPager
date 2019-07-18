package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Button
import com.bumptech.glide.Glide
import com.yy.magerpage.model.widget.base.ButtonWidgetModel
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.ui.widget.view.MagicViewHelper
import com.yy.magerpage.R

/**
 * Created by Sven on 17/05/2019
 */
class MagicButton(context: Context) : IMagic<ButtonWidgetModel, Button>(context) {
    override fun getContentView(): Button {
        return Button(context)
    }


    override fun analysisDetailData(model: ButtonWidgetModel) {
        mContentView?.let {
            it.text = model.text
        }
    }

}