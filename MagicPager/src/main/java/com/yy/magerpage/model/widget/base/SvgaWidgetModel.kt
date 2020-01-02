package com.yy.magerpage.model.widget.base

import android.graphics.Color
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.util.ColorUtil

/**
 * Created by Sven on 2019-09-29
 */
class SvgaWidgetModel : BaseWidgetModel() {
    init {
        type = WidgetModelType.SVGA_TYPE.type
    }

    //网络加载
    var sourceUrl: String? = null

    //asset加载
    var assetUrl: String? = null

    //svga播放次数
    var loops: Int = 1
    //播放时长 当duration = 0时 不自动停止
    var duration: Int = 0

    //停止动画后是否还原
    var cleanAfterStop: Boolean = true

    //注入svga text属性
    val textMap = HashMap<String, SvgaText>()
    val imageMap = HashMap<String, String>()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SvgaWidgetModel) return false
        if (!super.equals(other)) return false

        if (sourceUrl != other.sourceUrl) return false
        if (assetUrl != other.assetUrl) return false
        if (loops != other.loops) return false
        if (duration != other.duration) return false
        if (cleanAfterStop != other.cleanAfterStop) return false
        if (textMap != other.textMap) return false
        if (imageMap != other.imageMap) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (sourceUrl?.hashCode() ?: 0)
        result = 31 * result + (assetUrl?.hashCode() ?: 0)
        result = 31 * result + loops
        result = 31 * result + duration
        result = 31 * result + cleanAfterStop.hashCode()
        result = 31 * result + textMap.hashCode()
        result = 31 * result + imageMap.hashCode()
        return result
    }

    override fun toString(): String {
        return "SvgaWidgetModel(sourceUrl=$sourceUrl, assetUrl=$assetUrl, loops=$loops," +
                " duration=$duration, cleanAfterStop=$cleanAfterStop, textMap=$textMap, imageMap=$imageMap)"
    }
}

data class SvgaText(
    val text: String = "",
    val textSize: Float? = 20f,
    val color: Int? = Color.BLACK,
    val alignment: SvgaTextAlignment = SvgaTextAlignment.LEFT
) {
    constructor(
        text: String,
        textSize: Float?,
        color: String? = "#000000",
        alignment: SvgaTextAlignment
    ) : this(
        text,
        textSize,
        ColorUtil.parseColor(color),
        alignment
    )
}

enum class SvgaTextAlignment(val type: String) {

    LEFT("LEFT"),

    CENTER("CENTER"),

    RIGHT("RIGHT"),
}