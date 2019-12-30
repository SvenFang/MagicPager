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
        type = WidgetModelType.BUTTON_TYPE.type
    }

    override fun toString(): String {
        return "ButtonWidgetModel(text=$text, textSize=$textSize, textColor='$textColor')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ButtonWidgetModel) return false
        if (!super.equals(other)) return false

        if (text != other.text) return false
        if (textSize != other.textSize) return false
        if (textColor != other.textColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = text?.hashCode() ?: 0
        result = 31 * result + textSize
        result = 31 * result + textColor.hashCode()
        return result
    }
}