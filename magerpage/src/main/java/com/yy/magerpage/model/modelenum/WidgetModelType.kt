package com.yy.magerpage.model.modelenum


/**
 * Created by Sven on 15/05/2019
 */
enum class WidgetModelType(var type: String) {
    //基础类组件
    BLANK_TYPE("BLANK_TYPE"),

    TEXT_TYPE("TEXT_TYPE"),

    IMAGE_TYPE("IMAGE_TYPE"),

    BUTTON_TYPE("BUTTON_TYPE"),

    SVGA_TYPE("SVGA_TYPE"),

    //容器类组件
    GRID_TYPE("GRID_TYPE"),

    CAROUSEL_TYPE("CAROUSEL_TYPE"),

    LIST_TYPE("LIST_TYPE"),

    FRAME_TYPE("FRAME_TYPE"),

    FLEXBOX_TYPE("FLEXBOX_TYPE"),

    SLIDER_TYPE("SLIDER_TYPE"),

    SCROLL_TYPE("SCROLL_TYPE"),

    LINEAR_TYPE("LINEAR_TYPE"),

    //其他
    NAVIGATION_TYPE("NAVIGATION_TYPE")
}