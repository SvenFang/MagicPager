package com.yy.magerpage.ui.widget.view

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.DataParamFormater
import com.yy.magerpage.ui.widget.viewmapping.WidgetMapping
import com.yy.magerpage.util.LengthUtil

/**
 * Created by Sven on 17/05/2019
 */
class MagicViewHelper {
    companion object {
        fun analysisBase(view: View, model: BaseWidgetModel) {
            //设置背景 圆角
            val bg = GradientDrawable()
            bg.shape = GradientDrawable.RECTANGLE
            //设置圆角角度
            bg.cornerRadius = LengthUtil.length2px(model.corner.toDouble(), view.context).toFloat()
            //设置背景色
            bg.setColor(Color.parseColor(model.bgColor))
            bg.setStroke(model.border, Color.parseColor(model.borderColor))
            view.background = bg

            //padding margin
            val padding = DataParamFormater.formatPadding(model.padding)
            view.setPadding(
                LengthUtil.length2px(padding.left.toDouble(), view.context),
                LengthUtil.length2px(padding.top.toDouble(), view.context),
                LengthUtil.length2px(padding.right.toDouble(), view.context),
                LengthUtil.length2px(padding.bottom.toDouble(), view.context)
            )

            val params = view.layoutParams

            if (null != params) {
                val margin = DataParamFormater.formatMargin(model.margin)
                if (params is ViewGroup.MarginLayoutParams) {
                    //X Y
                    val x = model.x
                    val y = model.y

                    params.setMargins(
                        LengthUtil.length2px((margin.left + x).toDouble(), view.context),
                        LengthUtil.length2px((margin.top + y).toDouble(), view.context),
                        LengthUtil.length2px(margin.right.toDouble(), view.context),
                        LengthUtil.length2px(margin.bottom.toDouble(), view.context)
                    )
                }

                //宽高
                if (model.height < 0) {
                    params.height = model.height.toInt()
                } else {
                    params.height =
                        LengthUtil.length2px(model.height - margin.bottom - margin.top, view.context)
                }

                if (model.width < 0) {
                    params.width = model.width.toInt()
                } else {
                    params.width =
                        LengthUtil.length2px(model.width - margin.left - margin.right, view.context)
                }
                view.layoutParams = params
            }

            view.isEnabled = !model.disable

            //点击事件
            if (null != model.actionBlock) {
                //本地构造点击函数
                view.setOnClickListener {
                    var activity: Activity? = null
                    if (view.context is Activity) {
                        activity = view.context as Activity
                    }
                    model.actionBlock?.invoke(view.context, activity, model)
                }
            } else if (model.action != null && model.action!!.isNotEmpty()) {
                //json内容是js代码
                view.setOnClickListener {
                    MagicPagerManager.get().getPagerScript(view.context)?.evaluate(model.action!!)
                }
            }
        }

        fun createView(model: BaseWidgetModel, context: Context): IMagic<BaseWidgetModel, View>? {
            val viewClass = WidgetMapping.widgetMapping[model.type]?.viewClass
            val method = viewClass?.java?.getConstructor(Context::class.java)
            val view = method?.newInstance(context)
            view?.updateModel(model)
            return view
        }
    }
}