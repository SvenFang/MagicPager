package com.yy.magerpage.provider

import android.content.Context

/**
 * Created by Sven on 2019-06-28
 * js回调方法协议
 */
interface IActionProvider {
    fun getActionType(): String
    fun invoke(context: Context?, key: String, param: String?): String?
}
