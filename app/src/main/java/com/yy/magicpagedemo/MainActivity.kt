package com.yy.magicpagedemo

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.ImageViewTarget
import com.trello.rxlifecycle2.components.support.RxFragmentActivity
import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.model.request.PageRequestData
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.base.ImageWidgetModel
import com.yy.magerpage.model.widget.collection.CarouselWidgetModel
import com.yy.magerpage.model.widget.collection.FrameWidgetModel
import com.yy.magerpage.provider.ILog
import com.yy.magerpage.provider.IMagicProvider
import com.yy.magerpage.provider.MagicProviderCallBack
import com.yy.magicpagedemo.test.Test
import com.yy.magerpage.ui.MagicActivity
import com.yy.magerpage.ui.MagicDialogFragment
import com.yy.magerpage.ui.MagicFragment
import com.yy.magerpage.ui.MagicPopWindow
import com.yy.magicpagedemo.test.DialogDemo
import com.yy.magicpagedemo.test.PopWindowDemo
import com.yy.magicpagedemo.util.AssetReader
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : RxFragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMagic()

        supportFragmentManager.beginTransaction()
            .add(R.id.test_frame, MagicFragment.startMagic(PageRequestData("test", "test_frame")))
            .commit()

        val test1: Button = findViewById(R.id.test1Btn)
        val test2: Button = findViewById(R.id.test2Btn)
        val test3: Button = findViewById(R.id.test3Btn)

        test1.setOnClickListener {
            MagicActivity.startMagic(this, AssetReader.getTextModel())
        }

        test2.setOnClickListener {
            MagicActivity.startMagic(this, PageRequestData("test", "test_ad"))
        }

        test3.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, DynamicAddViewActivity::class.java)
            startActivity(intent)
        }

        tvDialogFragment.setOnClickListener {
            MagicDialogFragment.newInstance(DialogDemo.getTestModel())
                .show(supportFragmentManager, "MagicDialogFragment")
        }

        tvPopWindow.setOnClickListener {
            MagicPopWindow.newInstance(this, PopWindowDemo.getTestFrame())
                .show()
        }
    }


    private fun initMagic() {
        MagicPagerManager.get().setPagerWidth(375)

        MagicPagerManager.get().addPagerProvider(object : IMagicProvider {
            override fun getType(): String {
                return "test"
            }

            override fun getMagicData(
                key: String,
                params: Map<String, Any>?,
                callBack: MagicProviderCallBack
            ) {
                when (key) {
                    "test" -> callBack.onSuccess(AssetReader.getTextModel())
                    "test_ad" -> callBack.onSuccess(AssetReader.getAdModel())
                    "test_frame" -> callBack.onSuccess(Test.getTestFrame())
                    "DialogDemo" -> callBack.onSuccess(DialogDemo.getTestModel())
                    "PopWindow" -> callBack.onSuccess(PopWindowDemo.getTestFrame())
                }

            }
        })


        MagicPagerManager.get().logger = (object : ILog {
            override fun d(tag: String, format: String) {
                Log.d(tag, format)
            }

            override fun i(tag: String, format: String) {
                Log.i(tag, format)
            }

            override fun w(tag: String, format: String) {
                Log.w(tag, format)
            }

            override fun e(tag: String, format: String) {
                Log.e(tag, format)
            }

            override fun e(tag: String, format: String, e: Throwable) {
                Log.e(tag, format, e)
            }
        })


    }

    private fun getCarou(color: String): BaseWidgetModel {
        val carou = CarouselWidgetModel()
        carou.width = 375.0
        carou.height = 100.0
        carou.bgColor = color
        carou.autoPlay = true

        val colors = ArrayList<String>()
        colors.add("#ffff00")
        colors.add("#ffff55")
        colors.add("#ffffaa")
        for (i in 0..4) {
            val frame1 = FrameWidgetModel()
            frame1.width = 375.0
            frame1.height = 100.0
            for (j in 0..2) {
                val img = ImageWidgetModel()
                img.width = 60.0
                img.height = 60.0
                img.x = (100 + j * 50).toDouble()
                img.y = 20.0
                img.corner = 30.0
                img.borderColor = "#00ffff"
                img.bgColor = colors[j]
                img.border = 2.0
                frame1.items.add(img)
            }
            carou.items.add(frame1)
        }

        return carou
    }
}
