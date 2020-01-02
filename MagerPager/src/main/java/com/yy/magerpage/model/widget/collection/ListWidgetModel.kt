package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.ListWidgetType
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class ListWidgetModel : BaseCollectionWidgetModel() {
    init {
        type = WidgetModelType.LIST_TYPE.type
    }

    //SINGLE：单列 DOUBLE：双列瀑布流
    var listType: ListWidgetType = ListWidgetType.SINGLE

    override fun toString(): String {
        return "ListWidgetModel(listType=$listType)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ListWidgetModel) return false
        if (!super.equals(other)) return false

        if (listType != other.listType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + listType.hashCode()
        return result
    }
}