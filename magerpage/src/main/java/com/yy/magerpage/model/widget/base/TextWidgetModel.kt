package com.yy.magerpage.model.widget.base

import com.yy.magerpage.model.modelenum.HorizontalAlignment
import com.yy.magerpage.model.modelenum.VerticalAlignment
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class TextWidgetModel : BaseWidgetModel() {
    init {
        type = WidgetModelType.TEXT_TYPE.type
    }

    //文本内容
    var text: String? = null
    //字体大小（单位大小）
    var textSize: Int = 15
    //字体颜色
    var textColor: String = "#000000"
    //行距（单位大小）
    var lineSpacing: Int = 1
    //最大行数
    var maxLines: Int = 1
    //字体水平对其方向
    var textHorizontalAlignment: HorizontalAlignment = HorizontalAlignment.LEFT
    //字体垂直对其方向
    var textVerticalAlignment: VerticalAlignment = VerticalAlignment.TOP
    //是否粗体
    var bold: Boolean = false
    //是否斜体
    var italic: Boolean = false

    override fun toString(): String {
        return "TextWidgetModel(text=$text, textSize=$textSize, " +
                "textColor='$textColor', lineSpacing=$lineSpacing, maxLines=$maxLines, " +
                "textHorizontalAlignment=$textHorizontalAlignment, " +
                "textVerticalAlignment=$textVerticalAlignment)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TextWidgetModel) return false
        if (!super.equals(other)) return false

        if (text != other.text) return false
        if (textSize != other.textSize) return false
        if (textColor != other.textColor) return false
        if (lineSpacing != other.lineSpacing) return false
        if (maxLines != other.maxLines) return false
        if (textHorizontalAlignment != other.textHorizontalAlignment) return false
        if (textVerticalAlignment != other.textVerticalAlignment) return false
        if (bold != other.bold) return false
        if (italic != other.italic) return false

        return true
    }

    override fun hashCode(): Int {
        var result = text?.hashCode() ?: 0
        result = 31 * result + textSize
        result = 31 * result + textColor.hashCode()
        result = 31 * result + lineSpacing
        result = 31 * result + maxLines
        result = 31 * result + textHorizontalAlignment.hashCode()
        result = 31 * result + textVerticalAlignment.hashCode()
        result = 31 * result + bold.hashCode()
        result = 31 * result + italic.hashCode()
        return result
    }
}