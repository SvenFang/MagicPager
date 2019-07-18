package com.yy.magerpage.model.widget.base

import com.yy.magerpage.model.modelenum.HorizontalAlignemt
import com.yy.magerpage.model.modelenum.VerticalAlignemt
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class TextWidgetModel : BaseWidgetModel() {
    init {
        type = WidgetModelType.TEXT_TYPE
    }

    var text: String? = null
    var textSize: Int = 15
    var textColor: String = "#000000"
    var lineSpacing: Int = 1
    var maxLines: Int = 1
    var textHorizontalAlignemt: HorizontalAlignemt = HorizontalAlignemt.LEFT
    var textVerticalAlignemt: VerticalAlignemt = VerticalAlignemt.TOP
    var bold: Boolean = false
    var italic: Boolean = false

    override fun toString(): String {
        return "TextWidgetModel(text=$text, textSize=$textSize, textColor='$textColor', lineSpacing=$lineSpacing, maxLines=$maxLines, textHorizontalAlignemt=$textHorizontalAlignemt, textVerticalAlignemt=$textVerticalAlignemt)"
    }


}