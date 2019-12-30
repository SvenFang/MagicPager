package com.yy.magicpagedemo


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.yy.magerpage.model.modelenum.HorizontalAlignment
import com.yy.magerpage.model.modelenum.ListWidgetType
import com.yy.magerpage.model.modelenum.ScaleType
import com.yy.magerpage.model.modelenum.VerticalAlignment
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.Margin
import com.yy.magerpage.model.widget.Padding
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.model.widget.base.TextWidgetModel
import com.yy.magerpage.model.widget.collection.*
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.ui.widget.view.collection.MagicList


/**
 * Created by Sven on 2019-07-30
 */
class DynamicAddViewActivity : AppCompatActivity() {
    var refreshView: SmartRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_add_view)
        layoutView()
    }


    private fun layoutView() {
        findViewById<View>(R.id.btn_add).setOnClickListener {
            addMagicData()
        }
        refreshView = findViewById(R.id.refreshView)
        refreshView?.isEnableAutoLoadMore = true
        refreshView?.setOnLoadMoreListener {
            addMagicData()
        }
    }

    private fun addMagicData() {
        val items = model.items

        model = ListWidgetModel()
        model.width = 375.0
        model.listType = ListWidgetType.SINGLE
        model.bgColor = "#efefef"
        model.items = items
        addData()

        if (null == magicMagic) {
            val containerView = findViewById<FrameLayout>(R.id.container_view)
            magicMagic = MagicViewCreator.createView(model, this) as MagicList?
            containerView.addView(magicMagic)
        } else {
            magicMagic?.updateModel(model)
        }

        refreshView?.finishLoadMore(500)
    }

    private fun addData() {
        val topAd = CarouselWidgetModel()
        topAd.width = 375.0
        topAd.height = 80.0
        topAd.duration = 5000
        topAd.autoPlay = true
        topAd.dots = true
        topAd.dotSpace = 4
        topAd.dotWidth = 4
        topAd.margin = Margin(0, 5, 0, 5)
        topAd.dotSelectedColor = "#ffffff"
        topAd.bgColor = "#00ff00"
        for (i in 0..6) {
            val frame = FrameWidgetModel()
            frame.width = BaseWidgetModel.MATCH_PARENT
            frame.height = BaseWidgetModel.MATCH_PARENT
            val item = ImageWidgetModel()
            item.x = 12.0
            item.width = 351.0
            item.height = 70.0

            item.scaleType = ScaleType.CROP
            item.corner = 8.0

            frame.items.add(item)
            topAd.items.add(frame)
        }

        model.items.add(topAd)

        for (i in 0 until 10) {
            //每行放两个
            val cell = LinearWidgetModel()
            cell.orientation = Orientation.HORIZONTAL
            cell.margin = Margin(6, 0, 6, 0)
            cell.width = 375.0
            cell.height = 216.0

            for (j in 0 until 2) {
                val index = i * 2 + j
                cell.items.add(getFunnyItem())
            }

            model.items.add(cell)
        }
    }

    private fun getFunnyItem(): LinearWidgetModel {
        val item = LinearWidgetModel()
        item.width = 181.5
        item.height = 216.0
        item.horizontalAlignment = HorizontalAlignment.CENTER
        item.padding = Padding(0, 7)

        val frame = FrameWidgetModel()
//        frame.margin = Margin(0, 7, 0, 7)
        frame.width = 170.0
        frame.height = 170.0
        frame.corner = 10.0
        frame.bgColor = "#ff00ff"
        //大图
        val image = ImageWidgetModel()
        image.width = 170.0
        image.height = 170.0
        image.corner = 20.0
        image.scaleType = ScaleType.FIX
//        image.imgSrc = funnyChannel.channelLogo
        frame.items.add(image)

        //左上角角标
        val leftTipBg = ImageWidgetModel()
        leftTipBg.height = 24.0
//        leftTipBg.imgSrc = funnyChannel.livingBgImgUrl
        frame.items.add(leftTipBg)

        //左上角文字
        val leftTipText = TextWidgetModel()
        leftTipText.height = 24.0
        leftTipText.textSize = 12
        leftTipText.textColor = "#ffffff"
//        leftTipText.text = funnyChannel.livingDesc
        leftTipText.textVerticalAlignment = VerticalAlignment.CENTER
        leftTipText.margin = Margin(6, 0, 6, 0)
        frame.items.add(leftTipText)

        //左下角文字
        val leftBottomTip = TextWidgetModel()
//        leftBottomTip.bgColor = getTagColors(funnyChannel.tagColor)
        leftBottomTip.textSize = 12
        leftBottomTip.textColor = "#ffffff"
        leftBottomTip.padding = Padding(8, 2, 8, 2)
        leftBottomTip.corner = 4.0
//        leftBottomTip.text = funnyChannel.tag
        leftBottomTip.x = 8.0
        leftBottomTip.y = 142.0
        frame.items.add(leftBottomTip)

        //右下角人气
        val rightBottomLinear = LinearWidgetModel()
        rightBottomLinear.orientation = Orientation.HORIZONTAL
        rightBottomLinear.x = 80.0
        rightBottomLinear.y = 140.0
        rightBottomLinear.width = 80.0
        rightBottomLinear.height = 22.0
        rightBottomLinear.horizontalAlignment = HorizontalAlignment.RIGHT
        rightBottomLinear.verticalAlignment = VerticalAlignment.CENTER
        val fire = ImageWidgetModel()
//        fire.imgRes = R.drawable.ic_channel_hot
        rightBottomLinear.items.add(fire)
        val num = TextWidgetModel()
//        num.text = " ${funnyChannel.onlineNum}"
        num.textSize = 12
        num.textColor = "#B3FFFFFF"
        num.textVerticalAlignment = VerticalAlignment.CENTER
        rightBottomLinear.items.add(num)

        frame.items.add(rightBottomLinear)

        //右上皇冠位置
//        if (funnyChannel.bossUid > 0) {
//            val bossHead = ImageWidgetModel()
//            bossHead.width = 43.0
//            bossHead.height = 43.0
//            bossHead.corner = 21.5
//            bossHead.x = 118.0
//            bossHead.y = 8.0
//            if (StringUtils.isEmpty(funnyChannel.bossLogo)) {
//                bossHead.imgRes = com.yymobilecore.R.drawable.default_portrait_140_140
//            } else {
//                bossHead.imgSrc = funnyChannel.bossLogo
//            }
//
//            frame.items.add(bossHead)
//
//            val bossHeadFrame = ImageWidgetModel()
//            bossHeadFrame.width = 49.0
//            bossHeadFrame.height = 49.0
//            bossHeadFrame.x = 115.0
//            bossHeadFrame.y = 5.0
//            bossHeadFrame.imgSrc = funnyChannel.bossHeadUrl
//            frame.items.add(bossHeadFrame)
//        }

        //图片上内容
        item.items.add(frame)

        //标题
        val text = TextWidgetModel()
        text.width = 170.0
        text.textColor = "#333333"
        text.textSize = 13
//        text.text = funnyChannel.channelName
        text.padding = Padding(0, 7)
        item.items.add(text)

//        if (funnyChannel.topSid > 0) {
//            item.actionBlock = object : MagicAction {
//                override fun invoke(context: Context, activity: Activity?, model: BaseWidgetModel) {
//                    NavigationUtils.toGameVoiceChannel(context, funnyChannel.topSid, funnyChannel.subSid)
//                }
//            }
//        }
        return item
    }

    var model = ListWidgetModel()

    var magicMagic: MagicList? = null
}