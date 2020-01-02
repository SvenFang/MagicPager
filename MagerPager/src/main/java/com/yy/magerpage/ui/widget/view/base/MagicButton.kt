package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.util.TypedValue
import android.widget.Button

import com.yy.magerpage.model.widget.base.ButtonWidgetModel
import com.yy.magerpage.ui.widget.view.AbstractMagic
import com.yy.magerpage.util.ColorUtil
import com.yy.magerpage.util.LengthUtil


/**
 * Created by Sven on 17/05/2019
 * 用于生成文字按钮使用
 */
class MagicButton(context: Context) : AbstractMagic<ButtonWidgetModel, Button>(context) {
    override fun getContentView(): Button {
        return Button(context)
    }

    override fun analysisDetailData(model: ButtonWidgetModel) {
        mContentView?.let {
            it.text = model.text
            it.setTextColor(ColorUtil.parseColor(model.textColor))
            it.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                LengthUtil.length2px(model.textSize.toDouble(), context).toFloat()
            )
        }
    }
}