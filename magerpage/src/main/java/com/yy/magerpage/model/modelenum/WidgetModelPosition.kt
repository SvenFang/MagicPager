package com.yy.magerpage.model.modelenum

/**
 * Created by Sven on 15/05/2019
 */
enum class WidgetModelPosition(var type: Int) {
    //控件位置
    NONE(0),
    //fix
    TOP_FIX(1),
    BOTTOM_FIX(2),
    LEFT_FIX(3),
    RIGHT_FIX(4),

    //float
    TOP_FLOAT(5),
    BOTTOM_FLOAT(6),
    LEFT_FLOAT(7),
    RIGHT_FLOAT(8),

}