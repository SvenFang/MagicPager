package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetData

/**
 * Created by Sven on 10/05/2019
 */
class GridWidgetModel : BaseCollectionWidgetData() {
    init {
        type = WidgetModelType.GRID_TYPE
    }

    var row: Int = 1
    var column: Int = 1
}