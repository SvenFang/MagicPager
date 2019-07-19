package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.widget.Button
import com.yy.magerpage.model.widget.base.ButtonWidgetModel
import com.yy.magerpage.ui.widget.view.IMagic

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