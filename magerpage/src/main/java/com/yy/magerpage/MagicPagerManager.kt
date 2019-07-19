package com.yy.magerpage

import android.content.Context
import com.yy.magerpage.provider.*
import com.yy.magerpage.script.MagicScript
import com.yy.magerpage.script.ScriptBridge
import com.yy.magerpage.util.LengthUtil
import com.yy.magerpage.util.MLog
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by Sven on 2019-06-26
 */
class MagicPagerManager() {

    companion object {
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

    //全局数据
    private val gobleData = HashMap<String, Any>()

    private val pagerProviders = HashMap<String, IMagicProvider>()

    private val pagerScripts: WeakHashMap<Context, MagicScript> = WeakHashMap()

    var imageProvider: IImageLoadProvider? = null
    
    private val scriptBridge: ScriptBridge = ScriptBridge()
    fun getScriptBridge(): ScriptBridge {
        return scriptBridge
    }

    var log: ILog? = null

    fun setLoger(l: ILog) {
        log = l
    }

    fun addPagerProvider(provider: IMagicProvider) {
        pagerProviders[provider.getProviderType()] = provider
    }

    fun addActionProvider(provider: IActionProvider) {
        scriptBridge.addActionProvider(provider)
    }

    fun addPagerScript(context: Context, magicScript: MagicScript) {
        pagerScripts[context] = magicScript
        MLog.i("Sven", "scripts count -> ${pagerScripts.values.size}")
    }

    fun removePagerScript(context: Context) {
        pagerScripts.remove(context)
        MLog.i("Sven", "scripts count -> ${pagerScripts.values.size}")
    }


    fun getPagerScript(context: Context): MagicScript? {
        return pagerScripts[context]
    }

    fun getMagic(
        type: String,
        key: String,
        header: Map<String, Any>?,
        params: Map<String, Any>?,
        callBack: MagicProviderCallBack
    ) {
        pagerProviders[type]?.getMagicData(key, header, params, callBack)
    }

    fun setPagerWidth(width: Int) {
        LengthUtil.windowWidth = width
    }

    init {
        addActionProvider(MagicActionProvider())
    }
}