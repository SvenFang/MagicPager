package com.yy.magerpage.util

import android.graphics.Color

/**
 * Created by Sven on 2019-12-02
 */
object ColorUtil {
    fun parseColor(colorString: String?): Int {

        if (null == colorString) {
            return Color.TRANSPARENT
        }

        var nColor = colorString.trim()

        if (nColor.isNotEmpty() && "#" != nColor.substring(0, 1)) {
            nColor = "#$nColor"
        }

        return try {
            Color.parseColor(nColor)
        } catch (e: Exception) {
            Color.TRANSPARENT
        }
    }
}