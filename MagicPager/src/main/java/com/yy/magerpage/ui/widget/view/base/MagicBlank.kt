package com.yy.magerpage.ui.widget.view.base

import android.content.Context
import android.view.View
import com.yy.magerpage.model.widget.base.BlankWidgetModel
import com.yy.magerpage.ui.widget.view.AbstractMagic

/**
 * Created by Sven on 17/05/2019
 * 空白view 用户占位，设置分割线等使用
 */
class MagicBlank(context: Context) : AbstractMagic<BlankWidgetModel, View>(context) {

    override fun getContentView(): View {
        return View(context)
    }

    override fun analysisDetailData(model: BlankWidgetModel) {
    }
}