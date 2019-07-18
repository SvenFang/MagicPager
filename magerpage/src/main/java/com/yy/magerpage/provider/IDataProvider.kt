package com.yy.magerpage.provider


/**
 * Created by Sven on 2019-06-28
 */
interface IDataProvider {
    fun getProviderType(): String
    fun getData(key: String, header: Map<String, Any>, params: Map<String, Any>, callBack: DataProviderCallBack)
}

interface DataProviderCallBack {
    fun onSuccess(resp: Map<String, Any>)
    fun onError(error: String)
}