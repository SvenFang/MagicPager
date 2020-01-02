package com.yy.magerpage.model.widget.base

import com.yy.magerpage.model.modelenum.ScaleType
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 10/05/2019
 */
class ImageWidgetModel : BaseWidgetModel() {

    init {
        type = WidgetModelType.IMAGE_TYPE.type
    }

    //图片在线url
    var imgSrc: String? = null
    //本地图片资源Res
    var imgRes: Int? = null

    //图片填充方式
    var scaleType: ScaleType = ScaleType.INSIDE

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ImageWidgetModel) return false
        if (!super.equals(other)) return false

        if (imgSrc != other.imgSrc) return false
        if (imgRes != other.imgRes) return false
        if (scaleType != other.scaleType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imgSrc?.hashCode() ?: 0
        result = 31 * result + (imgRes ?: 0)
        result = 31 * result + scaleType.hashCode()
        return result
    }

    override fun toString(): String {
        return "ImageWidgetModel(imgSrc=$imgSrc, imgRes=$imgRes, scaleType=$scaleType)"
    }
}