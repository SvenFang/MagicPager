package com.yy.magerpage.provider

import com.yy.magerpage.model.container.MagicPagerModel

/**
 * Created by Sven on 2019-06-26
 */

interface IMagicProvider {
    fun getType(): String
    fun getMagicData(key: String, params: Map<String, Any>?, callBack: MagicProviderCallBack)
}

interface MagicProviderCallBack {
    fun onSuccess(resp: MagicPagerModel)
    fun onError(error: String)
}