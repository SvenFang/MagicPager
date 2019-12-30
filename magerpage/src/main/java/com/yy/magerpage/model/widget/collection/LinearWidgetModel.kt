package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.HorizontalAlignment
import com.yy.magerpage.model.modelenum.VerticalAlignment
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel

/**
 * Created by Sven on 2019-10-24
 */

class LinearWidgetModel : BaseCollectionWidgetModel() {
    var orientation = Orientation.VERTICAL

    //水平对其方向
    var horizontalAlignment: HorizontalAlignment = HorizontalAlignment.LEFT
    //垂直对其方向
    var verticalAlignment: VerticalAlignment = VerticalAlignment.TOP

    init {
        type = WidgetModelType.LINEAR_TYPE.type
    }

    override fun toString(): String {
        return "LinearWidgetModel(orientation=$orientation, " +
                "horizontalAlignment=$horizontalAlignment, verticalAlignment=$verticalAlignment)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LinearWidgetModel) return false
        if (!super.equals(other)) return false

        if (orientation != other.orientation) return false
        if (horizontalAlignment != other.horizontalAlignment) return false
        if (verticalAlignment != other.verticalAlignment) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + orientation.hashCode()
        result = 31 * result + horizontalAlignment.hashCode()
        result = 31 * result + verticalAlignment.hashCode()
        return result
    }
}

enum class Orientation(val type: String) {
    VERTICAL("VERTICAL"),
    HORIZONTAL("HORIZONTAL")
}