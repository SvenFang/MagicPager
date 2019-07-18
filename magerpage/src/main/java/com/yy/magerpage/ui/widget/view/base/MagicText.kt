package com.yy.magerpage.ui.widget.view.base

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import com.yy.magerpage.model.modelenum.HorizontalAlignemt
import com.yy.magerpage.model.modelenum.VerticalAlignemt
import com.yy.magerpage.model.widget.base.TextWidgetModel
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.util.LengthUtil


/**
 * Created by Sven on 17/05/2019
 */
@SuppressLint("ViewConstructor")
class MagicText(context: Context) :
    IMagic<TextWidgetModel, TextView>(context) {

    override fun getContentView(): TextView {
        return TextView(context)
    }

    override fun analysisDetailData(model: TextWidgetModel) {
        model.textHorizontalAlignemt
        model.textVerticalAlignemt
        mContentView?.let {
            it.text = model.text
            it.setTextColor(Color.parseColor(model.textColor))
            it.gravity = textGravite(model.textHorizontalAlignemt, model.textVerticalAlignemt)
            it.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                LengthUtil.length2px(model.textSize.toDouble(), context).toFloat()
            )
            it.maxLines = model.maxLines
            it.setLineSpacing(LengthUtil.length2px(model.lineSpacing.toDouble(), context).toFloat(), 1F)


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

    private fun textGravite(textHorizontalAlignemt: HorizontalAlignemt, textVerticalAlignemt: VerticalAlignemt): Int {
        val horizontal = when (textHorizontalAlignemt) {
            HorizontalAlignemt.LEFT -> Gravity.START
            HorizontalAlignemt.CENTER -> Gravity.CENTER_HORIZONTAL
            HorizontalAlignemt.RIGHT -> Gravity.END
        }

        val vertical = when (textVerticalAlignemt) {
            VerticalAlignemt.TOP -> Gravity.TOP
            VerticalAlignemt.CENTER -> Gravity.CENTER_VERTICAL
            VerticalAlignemt.BOTTOM -> Gravity.BOTTOM
        }

        return horizontal or vertical
    }


}