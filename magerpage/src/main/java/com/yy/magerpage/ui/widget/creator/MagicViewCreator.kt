package com.yy.magerpage.ui.widget.creator

import android.content.Context
import android.view.View
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.ui.widget.view.AbstractMagic
import com.yy.magerpage.ui.widget.viewmapping.WidgetMapping

/**
 * Created by Sven on 2019-10-17
 */
object MagicViewCreator {
    /**
     * 使用model 动态生成view
     */
    fun createView(model: BaseWidgetModel, context: Context): AbstractMagic<BaseWidgetModel, View>? {
        val viewClass = WidgetMapping.widgetMapping[model.type]?.viewClass
        val method = viewClass?.java?.getConstructor(Context::class.java)
        val view = method?.newInstance(context)
        view?.updateModel(model)
        return view
    }
}