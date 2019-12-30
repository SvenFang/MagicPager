package com.yy.magerpage.util

/**
 * Created by Sven on 2019-10-16
 */

class StringUtil {
    companion object {
        const val EMPTY = ""

        fun isEmpty(s: String?): Boolean {
            return s == null || s.isEmpty()
        }
    }
}