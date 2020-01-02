package com.yy.magerpage

import android.app.Activity
import android.content.Context
import com.yy.magerpage.model.json.MagicGson
import com.yy.magerpage.model.request.PageRequestData
import com.yy.magerpage.provider.IActionProvider
import com.yy.magerpage.ui.MagicActivity

/**
 * Created by Sven on 2019-07-09
 */
class MagicActionProvider : IActionProvider {
    companion object {
        const val TYPE = "magic"
        const val DISMISS = "dismiss"
        const val SHOW_PAGER = "show"
    }

    override fun getActionType(): String {
        return TYPE
    }

    override fun invoke(
        context: Context?,
        key: String,
        param: String?
    ): String? {
        return when (key) {
            DISMISS -> {
                if (context is Activity) {
                    context.finish()
                }
                return null
            }

            SHOW_PAGER -> {

                val requestParam = MagicGson.gson.fromJson(param, PageRequestData::class.java)

                if (null != context && null != requestParam) {
                    MagicActivity.startMagic(context, requestParam)
                }

                return "show page"
            }

            else -> null
        }
    }
}