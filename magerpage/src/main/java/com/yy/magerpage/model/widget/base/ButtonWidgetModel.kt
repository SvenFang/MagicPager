package com.yy.magerpage.model.widget.base

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class ButtonWidgetModel : BaseWidgetModel() {

    var text: String? = null
    var textSize: Int = 15
    var textColor: String = "#000000"

    init {
        type = WidgetModelType.BUTTON_TYPE
    }

    override fun toString(): String {
        return "ButtonWidgetModel(text=$text, textSize=$textSize, textColor='$textColor')"
    }


}