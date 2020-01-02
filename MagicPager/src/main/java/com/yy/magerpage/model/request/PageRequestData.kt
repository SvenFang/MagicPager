package com.yy.magerpage.model.request

import java.io.Serializable

/**
 * Created by Sven on 2019-10-16
 * page数据请求类
 */

class PageRequestData(
    val type: String,
    val key: String,
    val params: HashMap<String, Any>? = HashMap()
) : Serializable