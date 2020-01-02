package com.yy.magerpage.model.container

import com.yy.magerpage.model.modelenum.AnimStyle
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 2019-10-14
 * 扩展Dialog数据类
 */
class MagicDialogModel : MagicPagerModel() {
    var width: Double = BaseWidgetModel.WRAP_CONTENT
    var height: Double = BaseWidgetModel.WRAP_CONTENT
    //进出动画
    var animStyle: AnimStyle? = null
}