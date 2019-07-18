package com.yy.magerpage.script

import android.content.Context
import com.yy.magerpage.provider.IActionProvider

/**
 * Created by Sven on 2019-07-01
 */
class ScriptBridge {
    private val providers = HashMap<String, IActionProvider>()

    fun addActionProvider(provider: IActionProvider) {
        providers[provider.getActionType()] = provider
    }

    fun invoke(
        context: Context?,
        type: String,
        key: String,
        header: HashMap<String, Any>?,
        params: HashMap<String, Any>?
    ): String? {
        return providers[type]?.invoke(context, key, header, params)
    }
}