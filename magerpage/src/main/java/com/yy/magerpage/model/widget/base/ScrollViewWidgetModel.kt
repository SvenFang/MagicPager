package com.yy.magerpage.model.widget.base

import com.yy.magerpage.model.modelenum.OrientationType
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel

/**
 * @Date Created: 2019-10-15
 * @Author: hexiang
 * @Description:
 */
class ScrollViewWidgetModel : BaseCollectionWidgetModel() {
    init {
        type = WidgetModelType.SCROLL_TYPE.type
    }

    lateinit var orientation: OrientationType
    override fun toString(): String {
        return "ScrollViewWidgetModel(orientation=$orientation)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ScrollViewWidgetModel) return false
        if (!super.equals(other)) return false

        if (orientation != other.orientation) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + orientation.hashCode()
        return result
    }
}