package com.yy.magicpagedemo.test

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentActivity
import com.yy.magerpage.model.container.MagicDialogModel
import com.yy.magerpage.model.modelenum.HorizontalAlignment
import com.yy.magerpage.model.modelenum.ScaleType
import com.yy.magerpage.model.modelenum.VerticalAlignment
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.MagicAction
import com.yy.magerpage.model.widget.Margin
import com.yy.magerpage.model.widget.Padding
import com.yy.magerpage.model.widget.base.ButtonWidgetModel
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.model.widget.base.NavigationBarModel
import com.yy.magerpage.model.widget.base.TextWidgetModel
import com.yy.magerpage.model.widget.collection.FrameWidgetModel
import com.yy.magerpage.model.widget.collection.GridWidgetModel
import com.yy.magerpage.model.widget.collection.ListWidgetModel
import com.yy.magerpage.model.widget.collection.SliderWidgetModel
import com.yy.magerpage.util.AnimUtils
import com.yy.magerpage.util.CacheManage

/**
 * Created by Sven on 13/05/2019
 */
class DialogDemo {
    companion object {

        @JvmStatic
        fun getTestModel(): MagicDialogModel {
            val page = MagicDialogModel()
            page.animStyle = AnimUtils.getRandomAnimStyle()
            page.width = 295.0
            page.height = 360.0
            page.widget = getWidgets()
            page.navigationBar = getNavigation()
            return page
        }

        private fun getWidgets(): BaseWidgetModel {
            val list = ListWidgetModel()
            list.width = BaseWidgetModel.MATCH_PARENT
            list.height = BaseWidgetModel.MATCH_PARENT

            val widgets = ArrayList<BaseWidgetModel>()
            //文本
            var textModel = TextWidgetModel()

            //文本
            textModel.width = -1.0
            textModel.text = "以下是grid容器控件"
            textModel.margin = Margin(5, 5, 5, 5)
            textModel.padding = Padding(5, 5, 5, 5)
            textModel.bgColor = "#ffff00"
            widgets.add(textModel)

            widgets.add(testMogoTypes())

            //文本
            textModel = TextWidgetModel()
            textModel.width = -1.0
            textModel.text = "以下是横向slide容器控件"
            textModel.margin = Margin(5, 5, 5, 5)
            textModel.padding = Padding(5, 5, 5, 5)
            textModel.bgColor = "#ffff00"
            widgets.add(textModel)
            widgets.add(testSlideModel())

            list.items.addAll(widgets)
            return list
        }

        private fun getNavigation(): NavigationBarModel {
            val navigation = NavigationBarModel()
            navigation.height = 36.0
            navigation.width = -1.0

            val text = TextWidgetModel()
            text.text = "我是对话框?"
            text.textColor = "#000000"
            text.textSize = 20
            text.width = -1.0
            text.height = -1.0
            text.textVerticalAlignment = VerticalAlignment.CENTER
            text.textHorizontalAlignment = HorizontalAlignment.CENTER

            navigation.title = text
            val btnModel = ButtonWidgetModel()
            btnModel.text = "关闭"
            btnModel.width = 36.0
            btnModel.height = 36.0
            btnModel.actionBlock = object : MagicAction {
                override fun invoke(
                    context: Context,
                    activity: Activity?,
                    model: BaseWidgetModel
                ) {
                    if (activity is FragmentActivity) {

                        CacheManage.getCacheDialog(activity)
                            ?.dismiss()
                    }
                }

            }
            navigation.left = null
            btnModel.action = "native.call('magic','dismiss',null,null,null)"
            navigation.right = btnModel
            return navigation
        }

        private fun testMogoTypes(): BaseWidgetModel {
            val gridModel = GridWidgetModel()
            gridModel.width = 375.0
            gridModel.height = 285.0
            gridModel.column = 5
            gridModel.row = 3

            val titles =
                arrayListOf(
                    "女装",
                    "上衣",
                    "裤子",
                    "裙子",
                    "套装",
                    "女鞋",
                    "美妆个护",
                    "包包",
                    "配饰",
                    "内衣",
                    "男友",
                    "家具",
                    "母婴",
                    "食品",
                    "运动"
                )

            val imgs =
                arrayListOf(
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_5gc489a8e9ihjc75id9855ih7e7aa_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4dk1d1hjakh9idcg1ik2ghbhc001e_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_6afff7fl63960blf04kh1gl083ld9_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_0edi982h99ca9dk254h8bckdil0gf_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_2hb498c4ah157i76k5b0h225j147j_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4flb21c3kdc0h972ded69dd6016b6_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_80a3d4e73kijb41b257i519ij8a51_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_29fdaheg68bk9e35dj57177ac76g9_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_5d5j2h247g2id53h3hdge4j3be8gh_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_326ihcfk2g36d309ihlljebk30e68_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_5ah1fh01fijh2a6g25ie44el244af_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_13jk83l6d2c6bk156gikc97h9d826_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_02a8d20l8ff3d2ddej4ahlgc47h12_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190627_60dgefe9k795l95j1b1kka49ljkl3_150x150.jpg_640x640.v1cAC.40.webp",
                    "https://s10.mogucdn.com/mlcdn/c45406/190702_4abf1a2380cjl5f8h74e3ld36e843_150x150.jpg_640x640.v1cAC.40.webp"
                )

            for (i in 0..14) {
                val frame = FrameWidgetModel()
                frame.width = 1.0
                frame.height = 1.0
                frame.x = (i % 5).toDouble()
                frame.y = (i / 5).toDouble()

                val image = ImageWidgetModel()
                image.imgSrc = imgs[i]
                image.y = 5.0
                image.width = 375.0 / 5
                image.height = image.width - 10
                image.scaleType = ScaleType.INSIDE

                val text = TextWidgetModel()
                text.text = titles[i]
                text.width = 375.0 / 5
                text.height = 20.0
                text.textColor = "#333333"
                text.textSize = 13
                text.y = 75.0
                text.textHorizontalAlignment = HorizontalAlignment.CENTER

                frame.items.add(image)
                frame.items.add(text)

                gridModel.items.add(frame)
            }
            return gridModel
        }

        private fun testSlideModel(): SliderWidgetModel {
            val model = SliderWidgetModel()
            model.width = 375.0
            model.bgColor = "#efefef"

            val imgs = arrayListOf(
                "https://s11.mogucdn.com/mlcdn/c45406/190528_7geh92gbb3k950917ic5i3ch77cl8_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190727_0d0iia23bi0ag5c21di8e5b0ej3h9_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190704_1g271843ajei9hel2b36432a5kf11_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190712_55ca53bla7c6i4fcj6ajlh1hl15g4_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190526_639564i5gf8a2kb0dk759b065hcce_640x853.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/55cf19/190604_62bgblblg37856l41bae0fe847bej_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190626_72e7bgeajh9kc3h86hakddjihfage_640x850.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190711_375efebe90b86faiidl0d7g8aj02h_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190703_149h64e7982f2g1g5h0af72kgjj43_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/55cf19/190712_81klf7kjgihgg1hk5ac66lhklb1jf_640x960.jpg_640x854.v1cAC.40.webp",
                "https://s11.mogucdn.com/mlcdn/c45406/190715_27f66e225hbkij50chfdg697ldh8g_640x960.jpg_640x854.v1cAC.40.webp"
            )

            for (i in 0..10) {
                val image = ImageWidgetModel()
                image.scaleType = ScaleType.CROP
                image.imgSrc = imgs[i]
                image.width = 88.0
                image.height = 88.0
                image.margin = Margin(5, 5, 5, 5)
                model.items.add(image)
            }

            return model
        }

    }


}