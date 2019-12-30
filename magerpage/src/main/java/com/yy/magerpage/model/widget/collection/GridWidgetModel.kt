package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class GridWidgetModel : BaseCollectionWidgetModel() {
    init {
        type = WidgetModelType.GRID_TYPE.type
    }

    //内容所分成行数
    var row: Int = 1
    //内容所分成列数
    var column: Int = 1

    override fun toString(): String {
        return "GridWidgetModel(row=$row, column=$column)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GridWidgetModel) return false
        if (!super.equals(other)) return false

        if (row != other.row) return false
        if (column != other.column) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + row
        result = 31 * result + column
        return result
    }
}