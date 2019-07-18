package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.ListWidgetType
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetData

/**
 * Created by Sven on 10/05/2019
 */
class ListWidgetModel : BaseCollectionWidgetData() {
    init {
        type = WidgetModelType.LIST_TYPE
    }

    var listType: ListWidgetType = ListWidgetType.SINGLE

}