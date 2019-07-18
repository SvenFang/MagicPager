package com.yy.magicpagedemo.test

import android.util.Log
import com.yy.magerpage.model.MagicPagerModel
import com.yy.magerpage.model.modelenum.HorizontalAlignemt
import com.yy.magerpage.model.modelenum.ListWidgetType
import com.yy.magerpage.model.modelenum.VerticalAlignemt
import com.yy.magerpage.model.modelenum.WidgetModelPosition
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.*
import com.yy.magerpage.model.widget.collection.*
import org.w3c.dom.Text

/**
 * Created by Sven on 13/05/2019
 */
class Test {
    companion object {
        @JvmStatic
        fun getTestModel(): MagicPagerModel {
            val page = MagicPagerModel()
            page.bgColor = "#00ffff"
            page.widgets = getReuses()
            page.bgImage = "https://vipweb.bs2cdn.yy.com/vipinter_735aeba48ce743a09a8119533f25fe40.jpeg"
            page.refreshable = true
            return page
        }

        private fun getReuses(): ArrayList<BaseWidgetModel> {
            val widgets = ArrayList<BaseWidgetModel>()

            val colors = arrayListOf("#ff0000", "#ffff00", "#00ff00", "#0000ff", "#00ffff")
            for (i in 0..100) {
                val frame = FrameWidgetModel()
                frame.reuseId = 100
                frame.bgColor = colors[i % 4]
                frame.width = 375.0
                frame.height = 100 + Math.random() * 10

                for (j in 0..3) {
                    val text = TextWidgetModel()
                    text.x = (Math.random() * 10 + 30).toInt()
                    text.y = (Math.random() * 10 + 30 * j).toInt()
                    text.textSize = 20
                    text.textColor = "#000000"
                    text.text = "随机数" + Math.random()
                    text.width = 150.0
                    text.height = 40.0
                    frame.items.add(text)
                }
                widgets.add(frame)
            }


            return widgets
        }

        private fun getWidgets(): ArrayList<BaseWidgetModel> {
            val widgets = ArrayList<BaseWidgetModel>()
            //导航栏
            widgets.add(getNavigation())
            //文本
            val textModel = TextWidgetModel()
            textModel.text = "我是一个文本"
            widgets.add(textModel)
            //按钮
            val buttonModel = ButtonWidgetModel()
            buttonModel.text = "我是一个按钮"
            buttonModel.bgColor = "#ff00ff"
            buttonModel.corner = 10
            buttonModel.border = 2
            buttonModel.borderColor = "#0000ff"
            buttonModel.padding = "10,10,10,10"
            buttonModel.margin = "15,15,15,15"
            widgets.add(buttonModel)

            //图片
            val imageModel = ImageWidgetModel()
            imageModel.imgSrc = "https://upload.jianshu.io/users/upload_avatars" +
                    "/17775851/74897be1-1d4f-4968-909e-cb3cb67e7643?imageMogr2/auto-orient" +
                    "/strip|imageView2/1/w/240/h/240"

            widgets.add(imageModel)
            widgets.add(testGridModel())
            widgets.add(testCarouselModel())
            widgets.add(testListModel())
            widgets.add(testFlexbox())

            return widgets
        }

        private fun getNavigation(): NavigationBarModel {
            val navigation = NavigationBarModel()
            navigation.position = WidgetModelPosition.TOP_FIX
            navigation.height = 40.0
            navigation.width = 375.0

            val text = TextWidgetModel()
            text.text = "标题"
            text.textColor = "#000000"
            text.width = -1.0
            text.height = -1.0
            text.textVerticalAlignemt = VerticalAlignemt.CENTER
            text.textHorizontalAlignemt = HorizontalAlignemt.CENTER

            navigation.title = text
            navigation.bgColor = "#ff00ff"
            return navigation
        }

        private fun testGridModel(): GridWidgetModel {
            //Grid
            val gridModel = GridWidgetModel()
            gridModel.width = 375.0
            gridModel.height = 375.0
            gridModel.bgColor = "#ff0000"
            gridModel.column = 4
            gridModel.row = 4

            val item1 = ButtonWidgetModel()
            item1.text = "0,0,1,1"
            item1.bgColor = "#ff00ff"
            item1.width = 1.0
            item1.height = 1.0

            val item2 = ImageWidgetModel()
            item2.imgSrc = "https://upload.jianshu.io/users/upload_avatars" +
                    "/17775851/74897be1-1d4f-4968-909e-cb3cb67e7643?imageMogr2/auto-orient" +
                    "/strip|imageView2/1/w/240/h/240"
            item2.bgColor = "#ffffff"
            item2.x = 1
            item2.y = 1
            item2.width = 3.0
            item2.height = 3.0
            item2.margin = "5,5,5,5"
            item2.border = 8
            item2.borderColor = "#00ff00"

            val item3 = ButtonWidgetModel()
            item3.text = "1,0,3,1"
            item3.bgColor = "#0ff0ff"
            item3.x = 1
            item3.y = 0
            item3.width = 3.0
            item3.height = 1.0

            val item4 = ButtonWidgetModel()
            item4.text = "0,1,1,3"
            item4.bgColor = "#ffff00"
            item4.x = 0
            item4.y = 1
            item4.width = 1.0
            item4.height = 1.0

            gridModel.items.add(item1)
            gridModel.items.add(item2)
            gridModel.items.add(item3)
            gridModel.items.add(item4)
            return gridModel
        }

        private fun testCarouselModel(): CarouselWidgetModel {
            val model = CarouselWidgetModel()
            model.width = 375.0
            model.height = 100.0

            val item1 = ButtonWidgetModel()
            item1.text = "0,0,1,1"
            item1.bgColor = "#ff00ff"
            item1.width = 100.0
            item1.height = 100.0

            val item2 = ImageWidgetModel()
            item2.imgSrc = "https://upload.jianshu.io/users/upload_avatars" +
                    "/17775851/74897be1-1d4f-4968-909e-cb3cb67e7643?imageMogr2/auto-orient" +
                    "/strip|imageView2/1/w/240/h/240"
            item2.bgColor = "#ffffff"
            item2.width = 375.0
            item2.height = 100.0
            item2.margin = "5,5,5,5"
            item2.border = 8
            item2.borderColor = "#00ff00"

            val item3 = ButtonWidgetModel()
            item3.text = "1,0,3,1"
            item3.bgColor = "#0ff0ff"
            item3.width = 375.0
            item3.height = 100.0

            val item4 = ButtonWidgetModel()
            item4.text = "0,1,1,3"
            item4.bgColor = "#ffff00"
            item4.width = 375.0
            item4.height = 100.0
            model.items.add(item1)
            model.items.add(item2)
            model.items.add(item3)
            model.items.add(item4)
            return model
        }

        private fun testListModel(): ListWidgetModel {
            val model = ListWidgetModel()
            model.width = 375.0
            model.listType = ListWidgetType.DOUBLE

            val item1 = ButtonWidgetModel()
            item1.text = "0,0,1,1"
            item1.bgColor = "#ff00ff"
            item1.width = 160.0
            item1.height = 150.0

            val item2 = ImageWidgetModel()
            item2.imgSrc = "https://upload.jianshu.io/users/upload_avatars" +
                    "/17775851/74897be1-1d4f-4968-909e-cb3cb67e7643?imageMogr2/auto-orient" +
                    "/strip|imageView2/1/w/240/h/240"
            item2.bgColor = "#ffffff"
            item2.width = 160.0
            item2.height = 100.0
            item2.margin = "5,5,5,5"
            item2.border = 8
            item2.borderColor = "#00ff00"

            val item3 = ButtonWidgetModel()
            item3.text = "1,0,3,1"
            item3.bgColor = "#0ff0ff"
            item3.width = 160.0
            item3.height = 200.0

            val item4 = ButtonWidgetModel()
            item4.text = "0,1,1,3"
            item4.bgColor = "#ffff00"
            item4.width = 160.0
            item4.height = 300.0
            model.items.add(item1)
            model.items.add(item2)
            model.items.add(item3)
            model.items.add(item4)

            return model
        }

        private fun testFlexbox(): FlexboxWidgetModel {
            val model = FlexboxWidgetModel()
            model.flexWrap = MFlexWrap.WRAP


            val item1 = ButtonWidgetModel()
            item1.text = "0,0,1,1"
            item1.bgColor = "#ff00ff"
            item1.width = 100.0
            item1.height = 100.0

            val item2 = ImageWidgetModel()
            item2.imgSrc = "https://upload.jianshu.io/users/upload_avatars" +
                    "/17775851/74897be1-1d4f-4968-909e-cb3cb67e7643?imageMogr2/auto-orient" +
                    "/strip|imageView2/1/w/240/h/240"
            item2.bgColor = "#ffffff"
            item2.width = 375.0
            item2.height = 100.0
            item2.margin = "5,5,5,5"
            item2.border = 8
            item2.borderColor = "#00ff00"

            val item3 = ButtonWidgetModel()
            item3.text = "1,0,3,1"
            item3.bgColor = "#0ff0ff"
            item3.width = 375.0
            item3.height = 100.0

            val item4 = ButtonWidgetModel()
            item4.text = "0,1,1,3"
            item4.bgColor = "#ffff00"
            item4.width = 375.0
            item4.height = 100.0

            model.items.add(item1)
            model.items.add(item2)
            model.items.add(item3)
            model.items.add(item4)
            return model
        }


        var testObject = HashMap<String, String>()

    }


}