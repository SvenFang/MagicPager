package com.yy.magerpage.provider

import android.app.Activity
import android.content.Context
import com.yy.magerpage.model.MagicPagerModel
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 2019-06-28
 */
interface IActionProvider {

    fun getActionType(): String

    fun invoke(context: Context?, key: String, headers: Map<String, Any>?, params: Map<String, Any>?): String?
}

interface MagicAction {
    fun invoke(
        context: Context,
        activity: Activity?,
        model: BaseWidgetModel
    )
}

interface LoadMoreAction {
    fun invoke(
        context: Context,
        activity: Activity?,
        model: MagicPagerModel
    )
}