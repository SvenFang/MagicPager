package com.yy.magerpage.model.widget

/**
 * Created by Sven on 16/05/2019
 */
open class BaseCollectionWidgetModel : BaseWidgetModel() {

    var items: ArrayList<BaseWidgetModel> = ArrayList()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseCollectionWidgetModel) return false
        if (!super.equals(other)) return false

        if (items != other.items) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + items.hashCode()
        return result
    }
}