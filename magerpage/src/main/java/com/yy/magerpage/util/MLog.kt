package com.yy.magerpage.util

import com.yy.magerpage.MagicPagerManager

/**
 * Created by Sven on 2019-06-28
 */
object MLog {
    fun d(tag: String, format: String) {
        MagicPagerManager.get().log?.d(tag, format)
    }

    fun i(tag: String, format: String) {
        MagicPagerManager.get().log?.i(tag, format)
    }

    fun w(tag: String, format: String) {
        MagicPagerManager.get().log?.w(tag, format)
    }

    fun e(tag: String, format: String) {
        MagicPagerManager.get().log?.e(tag, format)
    }

    fun e(tag: String, format: String, e: Throwable) {
        MagicPagerManager.get().log?.e(tag, format, e)
    }
}