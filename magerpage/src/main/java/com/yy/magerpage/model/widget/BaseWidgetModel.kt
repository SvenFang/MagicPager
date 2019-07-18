package com.yy.magerpage.model.widget

import com.yy.magerpage.model.modelenum.WidgetModelPosition
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.provider.MagicAction

/**
 * Created by Sven on 16/05/2019
 */
open class BaseWidgetModel {
    var type: WidgetModelType = WidgetModelType.BLANK_TYPE
    var id: Long = 0
    var bgColor: String = "#00000000"
    var width: Double = -2.0
    var height: Double = -2.0
    var border: Int = 0
    var borderColor: String = "#00000000"
    var corner: Int = 0

    var padding: String = "0,0,0,0"
    var margin: String = "0,0,0,0"
    var x: Int = 0 //根据某些父容器适用
    var y: Int = 0 //根据某些父容器适用
    var position: WidgetModelPosition = WidgetModelPosition.NONE

    var action: String? = null
    //本地构建model使用 传入
    var actionBlock: MagicAction? = null
    //是否不可用
    val disable = false

    var reuseId: Int = 0 //view 重用id 0表示不重用

    override fun toString(): String {
        return "BaseWidgetModel(type=$type, id=$id, bgColor='$bgColor', width=$width, height=$height, border=$border, borderColor='$borderColor', corner=$corner, action=$action, padding='$padding', margin='$margin', x=$x, y=$y, position=$position, actionBlock=$actionBlock)"
    }

}