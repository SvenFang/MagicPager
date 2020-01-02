package com.yy.magerpage.model.widget.base

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class BlankWidgetModel : BaseWidgetModel() {
    init {
        type = WidgetModelType.BLANK_TYPE.type
    }
}