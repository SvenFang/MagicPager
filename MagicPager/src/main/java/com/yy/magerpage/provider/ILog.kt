package com.yy.magerpage.provider

/**
 * Created by Sven on 2019-06-28
 */
interface ILog {
    fun d(tag: String, format: String)

    fun i(tag: String, format: String)

    fun w(tag: String, format: String)

    fun e(tag: String, format: String)

    fun e(tag: String, format: String, e: Throwable)
}