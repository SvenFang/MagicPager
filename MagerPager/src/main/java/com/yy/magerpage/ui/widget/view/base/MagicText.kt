package com.yy.magerpage.ui.widget.view.base

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import com.yy.magerpage.model.modelenum.HorizontalAlignment
import com.yy.magerpage.model.modelenum.VerticalAlignment
import com.yy.magerpage.model.widget.base.TextWidgetModel
import com.yy.magerpage.ui.widget.view.AbstractMagic
import com.yy.magerpage.util.ColorUtil
import com.yy.magerpage.util.LengthUtil


/**
 * Created by Sven on 17/05/2019
 * 文本view
 */
@SuppressLint("ViewConstructor")
class MagicText(context: Context) :
    AbstractMagic<TextWidgetModel, TextView>(context) {

    override fun getContentView(): TextView {
        return TextView(context)
    }

    override fun analysisDetailData(model: TextWidgetModel) {
        model.textHorizontalAlignment
        model.textVerticalAlignment
        mContentView?.let {
            it.text = model.text
            it.setTextColor(ColorUtil.parseColor(model.textColor))
            it.gravity = textGravity(model.textHorizontalAlignment, model.textVerticalAlignment)
            it.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                LengthUtil.length2px(model.textSize.toDouble(), context).toFloat()
            )
            it.maxLines = model.maxLines
            it.setLineSpacing(
                LengthUtil.length2px(model.lineSpacing.toDouble(), context).toFloat(),
                1F
            )


            if (model.italic && model.bold) {
                it.setTypeface(Typeface.DEFAULT, Typeface.BOLD_ITALIC)
            } else if (model.italic) {
                it.setTypeface(Typeface.DEFAULT, Typeface.ITALIC)
            } else if (model.bold) {
                it.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            } else {
                it.setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
            }
        }
    }

    private fun textGravity(
        textHorizontalAlignment: HorizontalAlignment,
        textVerticalAlignment: VerticalAlignment
    ): Int {
        val horizontal = when (textHorizontalAlignment) {
            HorizontalAlignment.LEFT -> Gravity.START
            HorizontalAlignment.CENTER -> Gravity.CENTER_HORIZONTAL
            HorizontalAlignment.RIGHT -> Gravity.END
        }

        val vertical = when (textVerticalAlignment) {
            VerticalAlignment.TOP -> Gravity.TOP
            VerticalAlignment.CENTER -> Gravity.CENTER_VERTICAL
            VerticalAlignment.BOTTOM -> Gravity.BOTTOM
        }

        return horizontal or vertical
    }
}