package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel

/**
 * Created by Sven on 2019-10-14
 */
class SliderWidgetModel : BaseCollectionWidgetModel() {
    init {
        type = WidgetModelType.SLIDER_TYPE.type
    }
}