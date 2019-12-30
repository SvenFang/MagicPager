package com.yy.magerpage.ui.widget.view

import android.app.Activity
import android.content.ContextWrapper
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.ViewGroup
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.script.MagicScriptManager
import com.yy.magerpage.util.ColorUtil
import com.yy.magerpage.util.LengthUtil
import com.yy.magerpage.util.MLog

/**
 * Created by Sven on 17/05/2019
 */
class MagicViewHelper {
    companion object {
        private fun View.getActivity(): Activity? {
            var context = this.context
            while (context is ContextWrapper) {
                if (context is Activity) {
                    return context
                }
                context = context.baseContext
            }
            return null
        }

        fun analysisBase(view: View, model: BaseWidgetModel) {
            //设置背景 圆角
            val bg = GradientDrawable()
            bg.shape = GradientDrawable.RECTANGLE
            //设置圆角角度
            bg.cornerRadius = LengthUtil.length2px(model.corner, view.context).toFloat()
            //设置背景色
            bg.setColor(ColorUtil.parseColor(model.bgColor))
            bg.setStroke(
                LengthUtil.length2px(model.border, view.context),
                ColorUtil.parseColor(model.borderColor)
            )
            view.background = bg

            resize(view, model)

            view.isEnabled = !model.disable

            //点击事件
            if (null != model.actionBlock) {
                //本地构造点击函数
                view.setOnClickListener {
                    model.actionBlock?.invoke(view.context, view.getActivity(), model)
                }
            } else {
                //json内容是js代码
                model.action?.let { action ->
                    view.setOnClickListener {
                        MagicScriptManager.get().getPagerScript(view.context)?.evaluate(action)
                    }
                }
            }
        }

        private fun resize(view: View, model: BaseWidgetModel) {
            //padding margin
            val padding = model.padding
            view.setPadding(
                LengthUtil.length2px(padding.left, view.context),
                LengthUtil.length2px(padding.top, view.context),
                LengthUtil.length2px(padding.right, view.context),
                LengthUtil.length2px(padding.bottom, view.context)
            )

            val params = view.layoutParams

            if (null != params) {

                val margin = model.margin
                if (params is ViewGroup.MarginLayoutParams) {
                    //X Y
                    val x = model.x
                    val y = model.y

                    params.setMargins(
                        LengthUtil.length2px(margin.left + x, view.context),
                        LengthUtil.length2px(margin.top + y, view.context),
                        LengthUtil.length2px(margin.right, view.context),
                        LengthUtil.length2px(margin.bottom, view.context)
                    )
                }

                //宽高
                if (model.height < 0) {
                    params.height = model.height.toInt()
                } else {
                    params.height =
                        LengthUtil.length2px(
                            model.height - margin.bottom - margin.top,
                            view.context
                        )
                }

                if (model.width < 0) {
                    params.width = model.width.toInt()
                } else {
                    params.width =
                        LengthUtil.length2px(model.width - margin.left - margin.right, view.context)
                }
                view.layoutParams = params

                MLog.i(
                    "Sven",
                    "type -> ${view.javaClass}, width-> ${params.width}, height-> ${params.height}"
                )
            }
        }
    }
}