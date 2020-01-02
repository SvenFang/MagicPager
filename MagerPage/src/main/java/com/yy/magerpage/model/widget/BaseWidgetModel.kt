package com.yy.magerpage.model.widget


import android.app.Activity
import android.content.Context
import com.yy.magerpage.model.modelenum.WidgetModelType
import java.io.Serializable

/**
 * Created by Sven on 16/05/2019
 */


data class Padding(
    var left: Double = 0.0,
    var top: Double = 0.0,
    var right: Double = 0.0,
    var bottom: Double = 0.0
) : Serializable {
    constructor(
        left: Int = 0,
        top: Int = 0,
        right: Int = 0,
        bottom: Int = 0
    ) : this(
        left = left.toDouble(),
        top = top.toDouble(),
        right = right.toDouble(),
        bottom = bottom.toDouble()
    )
}

data class Margin(
    var left: Double = 0.0,
    var top: Double = 0.0,
    var right: Double = 0.0,
    var bottom: Double = 0.0
) : Serializable {
    constructor(
        left: Int = 0,
        top: Int = 0,
        right: Int = 0,
        bottom: Int = 0
    ) : this(
        left = left.toDouble(),
        top = top.toDouble(),
        right = right.toDouble(),
        bottom = bottom.toDouble()
    )
}

open class BaseWidgetModel : Serializable {
    companion object {
        const val MATCH_PARENT = -1.0
        const val WRAP_CONTENT = -2.0
    }

    //控件类型
    var type: String = WidgetModelType.BLANK_TYPE.type
    //控件背景颜色 默认透明
    var bgColor: String = "#00000000"
    //控件宽度/高度 -2:自适应宽度，-1:充满父控件 其他:单位长度
    var width: Double = WRAP_CONTENT
    var height: Double = WRAP_CONTENT
    //边框 单位长度边宽
    var border: Double = 0.0
    //边框颜色
    var borderColor: String = "#00000000"
    //控件圆角角度
    var corner: Double = 0.0
    //内边距
    var padding: Padding = Padding(0, 0, 0, 0)
    //外边距
    var margin: Margin = Margin(0, 0, 0, 0)
    //控件xy坐标
    var x: Double = 0.0 //根据某些父容器适用
    var y: Double = 0.0 //根据某些父容器适用

    //action 控件点击事件，可解析js方法
    var action: String? = null
    //本地构建model使用 传入
    var actionBlock: MagicAction? = null
    //不可点击，不拦截点击事件
    val disable = false
    //view 重用id 0表示不重用 至少同个type下唯一
    var reuseId: Int = 0
    //用于生成adapter重用typeId
    var adapterTypeId: Int = 0

    //数据绑定id 用于与业务数据做关联
    var bindId: String? = null

    override fun toString(): String {
        return "BaseWidgetModel(type='$type', bgColor='$bgColor', width=$width, height=$height," +
                " border=$border, borderColor='$borderColor', corner=$corner, padding=$padding," +
                " margin=$margin, x=$x, y=$y, action=$action, disable=$disable," +
                " reuseId=$reuseId, adapterTypeId=$adapterTypeId, bindId=$bindId)"
    }
}

/**
 * 用于本地构造控件点击事件
 */
interface MagicAction {
    fun invoke(
        context: Context,
        activity: Activity?,
        model: BaseWidgetModel
    )
}