package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class FlexBoxWidgetModel : BaseCollectionWidgetModel() {
    init {
        type = WidgetModelType.FLEXBOX_TYPE.type
    }

    var flexDirection: MFlexDirection = MFlexDirection.ROW
    var justifyContent: MJustifyContent = MJustifyContent.FLEX_START
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FlexBoxWidgetModel) return false
        if (!super.equals(other)) return false

        if (flexDirection != other.flexDirection) return false
        if (justifyContent != other.justifyContent) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + flexDirection.hashCode()
        result = 31 * result + justifyContent.hashCode()
        return result
    }

    override fun toString(): String {
        return "FlexBoxWidgetModel(flexDirection=$flexDirection, justifyContent=$justifyContent)"
    }
}

enum class MFlexDirection(val value: String) {
    ROW("ROW"),

    ROW_REVERSE("ROW_REVERSE"),

    COLUMN("COLUMN"),

    COLUMN_REVERSE("COLUMN_REVERSE")
}

enum class MJustifyContent(val value: String) {

    FLEX_START("FLEX_START"),

    FLEX_END("FLEX_END"),

    CENTER("CENTER"),
}



