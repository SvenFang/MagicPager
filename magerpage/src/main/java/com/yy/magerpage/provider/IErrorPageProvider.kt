package com.yy.magerpage.provider

import com.yy.magerpage.model.container.MagicPagerModel

/**
 * Created by Sven on 2019-10-17
 * 提供默认错误页面
 */
interface IErrorPageProvider {
    fun getErrorPage(errorMsg: String?): MagicPagerModel
}