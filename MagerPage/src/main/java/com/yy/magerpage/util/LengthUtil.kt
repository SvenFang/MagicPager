package com.yy.magerpage.util

import android.content.Context
import android.view.ViewGroup
import com.yy.magerpage.model.widget.BaseWidgetModel
import kotlin.math.roundToInt

/**
 * Created by Sven on 25/05/2019
 */
class LengthUtil {
    companion object {
        var windowWidth: Int = 375
        private var pxPerPoint: Double = 0.0

        private fun getPxPerPoint(context: Context): Double {
            if (pxPerPoint == 0.0) {
                val width = context.resources.displayMetrics.widthPixels
                pxPerPoint = width * 1.0 / windowWidth
            }

            return pxPerPoint
        }

        fun length2px(length: Double, context: Context): Int {
            return (length * getPxPerPoint(context)).roundToInt()
        }

        /**
         * 转像素，MATCH_PARENT，WRAP_CONTENT
         */
        fun formatWithAndHeight(width: Double, context: Context): Int {
            return when (width) {
                BaseWidgetModel.MATCH_PARENT -> ViewGroup.LayoutParams.MATCH_PARENT
                BaseWidgetModel.WRAP_CONTENT -> ViewGroup.LayoutParams.WRAP_CONTENT
                else -> length2px(width, context)
            }
        }
    }
}