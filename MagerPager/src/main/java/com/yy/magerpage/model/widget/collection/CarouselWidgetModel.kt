package com.yy.magerpage.model.widget.collection

import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseCollectionWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class CarouselWidgetModel : BaseCollectionWidgetModel() {
    init {
        type = WidgetModelType.CAROUSEL_TYPE.type
    }

    //轮播间隔
    var duration: Long = 5000
    //是否自动轮播
    var autoPlay: Boolean = true

    //是否展示滑点
    var dots: Boolean = true
    var dotSelectedColor: String = "#444444"
    var dotDefaultColor: String = "#bbbbbb"
    var dotSpace: Int = 4
    var dotWidth: Int = 4
    var dotsContainerHeight: Double = 10.0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CarouselWidgetModel) return false
        if (!super.equals(other)) return false

        if (duration != other.duration) return false
        if (autoPlay != other.autoPlay) return false
        if (dots != other.dots) return false
        if (dotSelectedColor != other.dotSelectedColor) return false
        if (dotDefaultColor != other.dotDefaultColor) return false
        if (dotSpace != other.dotSpace) return false
        if (dotWidth != other.dotWidth) return false
        if (dotsContainerHeight != other.dotsContainerHeight) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + duration.hashCode()
        result = 31 * result + autoPlay.hashCode()
        result = 31 * result + dots.hashCode()
        result = 31 * result + dotSelectedColor.hashCode()
        result = 31 * result + dotDefaultColor.hashCode()
        result = 31 * result + dotSpace
        result = 31 * result + dotWidth
        result = 31 * result + dotsContainerHeight.hashCode()
        return result
    }

    override fun toString(): String {
        return "CarouselWidgetModel(duration=$duration, autoPlay=$autoPlay," +
                " dots=$dots, dotSelectedColor='$dotSelectedColor'," +
                " dotDefaultColor='$dotDefaultColor', dotSpace=$dotSpace, " +
                "dotWidth=$dotWidth, dotsContainerHeight=$dotsContainerHeight)"
    }
}