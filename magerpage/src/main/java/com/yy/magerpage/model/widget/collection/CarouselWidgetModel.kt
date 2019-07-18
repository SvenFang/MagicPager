package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetData

/**
 * Created by Sven on 10/05/2019
 */
class CarouselWidgetModel : BaseCollectionWidgetData() {
    init {
        type = WidgetModelType.CAROUSEL_TYPE
    }

    var dots: Boolean = true
    var dotSelectedColor: String = "#444444"
    var dotDefaultColor: String = "#bbbbbb"
    var duration: Long = 5000
    var autoPlay: Boolean = true
}