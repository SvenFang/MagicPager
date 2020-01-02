package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Scroller
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.CarouselWidgetModel
import com.yy.magerpage.ui.widget.creator.MagicViewCreator
import com.yy.magerpage.ui.widget.view.AbstractCollectionMagic
import com.yy.magerpage.ui.widget.view.AbstractMagic
import com.yy.magerpage.ui.widget.view.base.MagicBlank
import com.yy.magerpage.util.ColorUtil
import com.yy.magerpage.util.LengthUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.WeakHashMap
import java.util.concurrent.TimeUnit


/**
 * Created by Sven on 14/10/2019
 * 轮播广告页
 */
class MagicCarousel(context: Context) :
    AbstractCollectionMagic<CarouselWidgetModel, RelativeLayout>(context) {

    private var mTimer: Disposable? = null
    private var mViewPager: ViewPager? = null
    private var mAdapter: CarouselAdapter? = null

    private var mDotsContainer: LinearLayout? = null
    private var mDotsViewMap: WeakHashMap<Int, View> = WeakHashMap()
    private var mViewPagerState: Int = 0 //0：IDLE

    override
    fun getContentView(): RelativeLayout {
        return RelativeLayout(context)
    }

    override fun analysisCollectionData(model: CarouselWidgetModel) {

        initPagerView()

        if (model.dots && model.items.size > 1) {
            if (mDotsContainer == null) {
                mDotsContainer = LinearLayout(context)
                mDotsContainer?.let {
                    it.gravity = Gravity.CENTER
                    it.orientation = LinearLayout.HORIZONTAL
                }
                mContentView!!.addView(mDotsContainer)
            } else {
                mDotsContainer?.removeAllViews()
            }

            val layoutParam = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParam.height = LengthUtil.length2px(model.dotsContainerHeight, context)
            layoutParam.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
            layoutParam.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
            layoutParam.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
            mDotsContainer!!.layoutParams = layoutParam

            for (i in model.items.indices) {
                val dot = View(context)
                val dotLayoutParam = LinearLayout.LayoutParams(
                    LengthUtil.length2px(model.dotWidth.toDouble(), context),
                    LengthUtil.length2px(model.dotWidth.toDouble(), context)
                )

                dotLayoutParam.setMargins(
                    LengthUtil.length2px(model.dotSpace.toDouble() / 2, context),
                    0,
                    LengthUtil.length2px(model.dotSpace.toDouble() / 2, context),
                    0
                )

                val bg = GradientDrawable()
                bg.shape = GradientDrawable.RECTANGLE
                //设置圆角角度
                bg.cornerRadius =
                    LengthUtil.length2px(model.dotWidth.toDouble() / 2, context).toFloat()
                dot.background = bg

                mDotsContainer!!.addView(dot, dotLayoutParam)
                mDotsViewMap[i] = dot
                //设置背景色
                mViewPager?.currentItem?.let { changeSelectedDot(it) }
            }
        } else {
            mDotsContainer?.let {
                mContentView!!.removeView(it)
            }
        }
    }

    private fun initPagerView() {
        if (null == mAdapter) {
            mAdapter = CarouselAdapter(mModel!!.items)
        }

        if (null == mViewPager) {
            mViewPager = ViewPager(context)
            mContentView!!.addView(mViewPager, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            mViewPager!!.adapter = mAdapter
            mViewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(p0: Int) {
                    mViewPagerState = p0
                }

                override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                }

                override fun onPageSelected(p0: Int) {
                    changeSelectedDot(p0)
                }
            })
            setScrollDuration(500)
        }
    }

    /**
     * 设置ViewPager的滚动速度
     * @param duration page切换的时间长度
     */
    private fun setScrollDuration(duration: Int) {
        try {
            // 通过class文件获取mScroller属性
            val mField = ViewPager::class.java.getDeclaredField("mScroller")
            mField.isAccessible = true
            val scroller = FixedSpeedScroller(context)
            scroller.duration = duration
            mField.set(mViewPager, scroller)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun updateItem(
        model: CarouselWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: AbstractMagic<BaseWidgetModel, View>
    ) {
    }

    override fun createItem(
        model: CarouselWidgetModel,
        itemModel: BaseWidgetModel
    ): AbstractMagic<BaseWidgetModel, View>? {
        return null
    }

    override fun afterUpdateItems() {
        mAdapter?.updateItems(mModel!!.items)
    }

    private fun initTimer(duration: Long) {
        if (duration > 0) {
            mTimer?.dispose()
            mTimer = Observable.interval(duration, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    changePage()
                }
        }
    }

    /**----------------- public method ------------------------ */
    fun startAnimator() {
        mModel?.let {
            if (it.items.size > 1 && it.autoPlay) {
                initTimer(it.duration)
            }
        }
    }

    fun stopAnimator() {
        mTimer?.dispose()
    }

    /**----------------- private method ------------------------ */
    private fun changePage() {
        mViewPager?.let {
            if (mViewPagerState == 0) {
                it.setCurrentItem(it.currentItem + 1, true)
            }
        }
    }

    private fun changeSelectedDot(selectedIndex: Int) {
        mDotsViewMap.entries.forEach {
            val bg = it.value.background
            if (bg is GradientDrawable) {
                if (it.key == selectedIndex % mModel!!.items.size) {
                    bg.setColor(ColorUtil.parseColor(mModel!!.dotSelectedColor))
                } else {
                    bg.setColor(ColorUtil.parseColor(mModel!!.dotDefaultColor))
                }
            }
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mTimer?.dispose()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mModel?.let {
            if (it.autoPlay && it.items.size > 1) {
                //重设一次，解决第一次自动滑动无动画
                analysisCollectionData(it)
                initTimer(it.duration)
            }
        }
    }

    class CarouselAdapter(private var pagerItems: List<BaseWidgetModel>) : PagerAdapter() {
        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 == p1
        }

        override fun getCount(): Int {
            return when {
                pagerItems.size > 1 -> Int.MAX_VALUE
                else -> pagerItems.size
            }
        }

        fun updateItems(items: List<BaseWidgetModel>) {
            pagerItems = items
            notifyDataSetChanged()
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            if (pagerItems.isEmpty()) return View(container.context)

            val index = itemIndex(position)

            val model = pagerItems[index]
            val magicView = MagicViewCreator.createView(model, container.context)
            val view = when {
                null != magicView -> magicView
                else -> MagicBlank(container.context)
            }
            container.addView(
                view,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            return view
        }

        private fun itemIndex(position: Int): Int {
            return if (pagerItems.isNotEmpty()) {
                position % pagerItems.size
            } else {
                0
            }
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        }
    }
}

class FixedSpeedScroller(context: Context?) : Scroller(context) {

    private var mDuration = 800

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
        startScroll(startX, startY, dx, dy, mDuration)
    }

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
        super.startScroll(startX, startY, dx, dy, mDuration)
    }

    fun setDuration(duration: Int) {
        mDuration = duration
    }
}