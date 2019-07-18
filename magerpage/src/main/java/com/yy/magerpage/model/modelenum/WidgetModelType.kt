package com.yy.magerpage.model.modelenum

/**
 * Created by Sven on 15/05/2019
 */
enum class WidgetModelType(var type: String) {
    //基础类组件
    BLANK_TYPE("blank"),
    TEXT_TYPE("text"),
    IMAGE_TYPE("image"),
    BUTTON_TYPE("button"),

    //容器类组件
    GRID_TYPE("grid"),
    CAROUSEL_TYPE("carousel"),
    LIST_TYPE("list"),
    FRAME_TYPE("frame"),
    FLEXBOX_TYPE("flexbox"),

    //其他
    NAVIGATION_TYPE("navigation")
}