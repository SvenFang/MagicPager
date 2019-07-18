package com.yy.magerpage.ui.widget.view.base

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.BlankWidgetModel
import com.yy.magerpage.model.widget.base.ButtonWidgetModel
import com.yy.magerpage.ui.widget.view.IMagic

/**
 * Created by Sven on 17/05/2019
 */
class MagicBlank(context: Context) : IMagic<BlankWidgetModel, View>(context) {

    override fun getContentView(): View {
        return View(context)
    }

    override fun analysisDetailData(model: BlankWidgetModel) {
    }

}