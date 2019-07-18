package com.yy.magerpage.provider

import com.yy.magerpage.model.MagicPagerModel

/**
 * Created by Sven on 2019-06-26
 */

interface IMagicProvider {
    fun getProviderType(): String
    fun getMagicData(key: String, header: Map<String, Any>?, params: Map<String, Any>?, callBack: MagicProviderCallBack)
}

public interface MagicProviderCallBack {
    fun onSuccess(resp: MagicPagerModel)
    fun onError(error: String)
}