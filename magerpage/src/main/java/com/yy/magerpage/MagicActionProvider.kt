package com.yy.magerpage

import android.app.Activity
import android.content.Context
import com.yy.magerpage.model.json.MagicGson
import com.yy.magerpage.provider.IActionProvider
import com.yy.magerpage.ui.MagicActivity
import com.yy.magerpage.ui.MagicFragment

/**
 * Created by Sven on 2019-07-09
 */
class MagicActionProvider : IActionProvider {
    companion object {
        @JvmStatic
        val TYPE = "magic"
        @JvmStatic
        val DISMISS = "dismiss"
        @JvmStatic
        val SHOW_PAGER = "showPager"
        @JvmStatic
        val MAGIC_KEY = "key"
        @JvmStatic
        val MAGIC_Type = "type"
        @JvmStatic
        val MAGIC_PARAMS = "params"
        @JvmStatic
        val MAGIC_HEADERS = "headers"
    }

    override fun getActionType(): String {
        return TYPE
    }

    override fun invoke(
        context: Context?,
        key: String,
        headers: Map<String, Any>?,
        params: Map<String, Any>?
    ): String? {
        return when (key) {
            DISMISS -> {
                if (context is Activity) {
                    context.finish()
                }
                return null
            }

            SHOW_PAGER -> {
                val key = params?.get(MAGIC_KEY)
                val type = params?.get(MAGIC_Type)

                val headers = params?.get(MAGIC_HEADERS)
                val params = params?.get(MAGIC_PARAMS)

                val headerStr = MagicGson.gson.toJson(headers)
                val paramsStr = MagicGson.gson.toJson(params)

                if (context != null && key is String && type is String) {
                    MagicActivity.startMagic(context, type, key, headerStr, paramsStr)
                }

                return null
            }

            else -> null
        }

    }
}