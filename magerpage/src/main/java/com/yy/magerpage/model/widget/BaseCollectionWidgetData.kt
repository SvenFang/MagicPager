package com.yy.magerpage.model.widget

/**
 * Created by Sven on 16/05/2019
 */
open class BaseCollectionWidgetData : BaseWidgetModel() {
    var items: ArrayList<BaseWidgetModel> = ArrayList()

    override fun toString(): String {
        return "BaseCollectionWidgetData(items=$items)"
    }

}