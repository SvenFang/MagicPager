package com.yy.magerpage.util

import android.content.Context
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
    }


}