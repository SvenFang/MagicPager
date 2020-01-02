package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel

/**
 * Created by Sven on 2019-07-03
 */
class FrameWidgetModel : BaseCollectionWidgetModel() {
    init {
        type = WidgetModelType.FRAME_TYPE.type
    }
}