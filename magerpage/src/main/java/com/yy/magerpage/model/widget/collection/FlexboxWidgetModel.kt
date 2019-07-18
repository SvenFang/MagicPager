package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetData

/**
 * Created by Sven on 10/05/2019
 */
class FlexboxWidgetModel : BaseCollectionWidgetData() {
    init {
        type = WidgetModelType.FLEXBOX_TYPE
    }

    var flexDirection: MFlexDirection = MFlexDirection.ROW
    var flexWrap: MFlexWrap = MFlexWrap.NOWRAP
    var justifyContent: MJustifyContent = MJustifyContent.FLEX_START
    var alignItems: MAlignItems = MAlignItems.STRETCH
    var alignContent: MAlignContent = MAlignContent.STRETCH
}

enum class MFlexDirection(val value: Int) {
    ROW(0),
    ROW_REVERSE(1),
    COLUMN(2),
    COLUMN_REVERSE(3)
}

enum class MFlexWrap(val value: Int) {
    NOWRAP(0),
    WRAP(1),
    WRAP_REVERSE(2)
}

enum class MJustifyContent(val value: Int) {
    FLEX_START(0),
    FLEX_END(1),
    CENTER(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4)
}

enum class MAlignItems(val value: Int) {
    STRETCH(0),
    FLEX_START(1),
    FLEX_END(2),
    CENTER(3),
    BASELINE(4),
}

enum class MAlignContent(val value: Int) {
    STRETCH(0),
    FLEX_START(1),
    FLEX_END(2),
    CENTER(3),
    SPACE_BETWEEN(4),
    SPACE_AROUND(5),
}



