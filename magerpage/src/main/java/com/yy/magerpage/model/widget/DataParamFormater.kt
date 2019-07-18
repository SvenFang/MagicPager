package com.yy.magerpage.model.widget

/**
 * Created by Sven on 16/05/2019
 */
object DataParamFormater {
    fun formatPadding(str: String): Padding {
        val list = str.split(",")
        if (list.size != 4) return Padding(0, 0, 0, 0)
        return Padding(list[0].toInt(), list[1].toInt(), list[2].toInt(), list[3].toInt())
    }

    fun formatMargin(str: String): Margin {
        val list = str.split(",")
        if (list.size != 4) return Margin(0, 0, 0, 0)
        return Margin(list[0].toInt(), list[1].toInt(), list[2].toInt(), list[3].toInt())
    }
}

open class Padding(var left: Int, var top: Int, var right: Int, var bottom: Int)
open class Margin(var left: Int, var top: Int, var right: Int, var bottom: Int)