package com.yy.magerpage.model.widget.base

import com.yy.magerpage.model.modelenum.ScaleType
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class ImageWidgetModel : BaseWidgetModel() {
    var imgSrc: String? = null
    var imgRes: Int? = null
    var scaleType: ScaleType = ScaleType.INSIDE

    init {
        type = WidgetModelType.IMAGE_TYPE
    }

    override fun toString(): String {
        return "ImageWidgetModel(imgSrc=$imgSrc, scaleType=$scaleType)"
    }
}