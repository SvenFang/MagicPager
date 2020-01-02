package com.yy.magerpage

import com.yy.magerpage.provider.IMagicProvider
import com.yy.magerpage.provider.IErrorPageProvider
import com.yy.magerpage.provider.ILog
import com.yy.magerpage.provider.IActionProvider
import com.yy.magerpage.provider.MagicProviderCallBack
import com.yy.magerpage.script.ScriptBridge
import com.yy.magerpage.util.LengthUtil
import kotlin.collections.HashMap

/**
 * Created by Sven on 2019-06-26
 */
class MagicPagerManager {

    companion object {
        private const val TAG = "MagicPagerManager"
        private var instance: MagicPagerManager? = null
            get() {
                if (field == null) {
                    field = MagicPagerManager()
                }
                return field
            }

        @Synchronized
        fun get(): MagicPagerManager {
            return instance!!
        }
    }

    private val pagerProviders = HashMap<String, IMagicProvider>()
    val scriptBridge: ScriptBridge = ScriptBridge()

    /**
     * 设置默认错误页面提供者
     */
    var errorPageProvider: IErrorPageProvider? = null

    /**
     * 设置日志实现
     */
    var logger: ILog? = null

    /**
     * 设置页面宽度
     */
    fun setPagerWidth(width: Int) {
        LengthUtil.windowWidth = width
    }

    /**
     * 添加页面提供者
     */
    fun addPagerProvider(provider: IMagicProvider) {
        pagerProviders[provider.getType()] = provider
    }

    /**
     * 添加json内js函数调用支持
     */
    fun addActionProvider(provider: IActionProvider) {
        scriptBridge.addActionProvider(provider)
    }

    fun getMagic(
        type: String,
        key: String,
        params: Map<String, Any>?,
        callBack: MagicProviderCallBack
    ) {
        pagerProviders[type]?.getMagicData(key, params, callBack)
    }

    init {
        addActionProvider(MagicActionProvider())
    }
}