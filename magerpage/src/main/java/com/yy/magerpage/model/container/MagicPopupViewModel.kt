package com.yy.magerpage.model.container

import com.yy.magerpage.model.modelenum.AnimStyle
import com.yy.magerpage.model.modelenum.GravityType
import com.yy.magerpage.model.widget.BaseWidgetModel

/**
 * Created by Sven on 2019-10-14
 * 扩展popupView数据类
 */
class MagicPopupViewModel : MagicPagerModel() {

    var width: Double = BaseWidgetModel.WRAP_CONTENT
    var height: Double = BaseWidgetModel.WRAP_CONTENT
    var gravityType: GravityType = GravityType.CENTER

    var x: Double = 0.0
    var y: Double = 0.0
    //进出动画
    var animStyle: AnimStyle? = null
}
