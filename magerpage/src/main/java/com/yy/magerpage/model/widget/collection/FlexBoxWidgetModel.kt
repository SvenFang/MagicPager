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
    var flexWrap: MFlexWrap = MFlexWrap.NOWRAP
    var justifyContent: MJustifyContent = MJustifyContent.FLEX_START
    var alignItems: MAlignItems = MAlignItems.STRETCH
    var alignContent: MAlignContent = MAlignContent.STRETCH
    override fun toString(): String {
        return "FlexBoxWidgetModel(flexDirection=$flexDirection, flexWrap=$flexWrap, " +
                "justifyContent=$justifyContent, alignItems=$alignItems, alignContent=$alignContent)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FlexBoxWidgetModel) return false
        if (!super.equals(other)) return false

        if (flexDirection != other.flexDirection) return false
        if (flexWrap != other.flexWrap) return false
        if (justifyContent != other.justifyContent) return false
        if (alignItems != other.alignItems) return false
        if (alignContent != other.alignContent) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + flexDirection.hashCode()
        result = 31 * result + flexWrap.hashCode()
        result = 31 * result + justifyContent.hashCode()
        result = 31 * result + alignItems.hashCode()
        result = 31 * result + alignContent.hashCode()
        return result
    }
}

enum class MFlexDirection(val value: String) {
    ROW("ROW"),

    ROW_REVERSE("ROW_REVERSE"),

    COLUMN("COLUMN"),

    COLUMN_REVERSE("COLUMN_REVERSE")
}

enum class MFlexWrap(val value: String) {

    NOWRAP("NOWRAP"),

    WRAP("WRAP"),

    WRAP_REVERSE("WRAP_REVERSE")
}

enum class MJustifyContent(val value: String) {

    FLEX_START("FLEX_START"),

    FLEX_END("FLEX_END"),

    CENTER("CENTER"),

    SPACE_BETWEEN("SPACE_BETWEEN"),

    SPACE_AROUND("SPACE_AROUND")
}

enum class MAlignItems(val value: String) {

    STRETCH("STRETCH"),

    FLEX_START("FLEX_START"),

    FLEX_END("FLEX_END"),

    CENTER("CENTER"),

    BASELINE("BASELINE"),
}

enum class MAlignContent(val value: String) {

    STRETCH("STRETCH"),

    FLEX_START("FLEX_START"),

    FLEX_END("FLEX_END"),

    CENTER("CENTER"),

    SPACE_BETWEEN("SPACE_BETWEEN"),

    SPACE_AROUND("SPACE_AROUND"),
}



