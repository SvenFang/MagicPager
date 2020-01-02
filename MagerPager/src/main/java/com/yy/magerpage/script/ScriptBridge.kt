package com.yy.magerpage.script

import android.content.Context
import com.yy.magerpage.provider.IActionProvider
import java.util.WeakHashMap

/**
 * Created by Sven on 2019-07-01
 */
class ScriptBridge {

    private val providers = WeakHashMap<String, IActionProvider>()

    fun addActionProvider(provider: IActionProvider) {
        providers[provider.getActionType()] = provider
    }

    fun invoke(
        context: Context?,
        type: String,
        key: String,
        param: String?
    ): String? {
        return providers[type]?.invoke(context, key, param)
    }
}