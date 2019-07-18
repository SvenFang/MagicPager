package com.yy.magerpage.ui.widget.view.collection

import android.content.Context
import android.graphics.Color
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.model.widget.collection.CarouselWidgetModel
import com.yy.magerpage.ui.widget.view.ICollectionMagic
import com.yy.magerpage.ui.widget.view.IMagic
import com.yy.magerpage.ui.widget.view.MagicViewHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * Created by Sven on 17/05/2019
 */
class MagicCarousel(context: Context) :
    ICollectionMagic<CarouselWidgetModel, RelativeLayout>(context) {


    private var mTimer: Disposable? = null
    private var mViewPager: ViewPager? = null
    private var mAdapter: CarouselAdapter? = null

    override fun getContentView(): RelativeLayout {
        return RelativeLayout(context)
    }

    override fun analysisCollectionData(model: CarouselWidgetModel) {
        mViewPager = ViewPager(context)

        mContentView!!.addView(mViewPager, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        mAdapter = CarouselAdapter(this.items)
        mViewPager?.adapter = mAdapter

        if (model.autoPlay) {
            initTimer(model.duration)
        }
    }

    override fun updateItem(
        model: CarouselWidgetModel,
        itemModel: BaseWidgetModel,
        itemView: IMagic<BaseWidgetModel, View>
    ) {
        itemView.updateModel(itemModel)
    }

    override fun createItem(model: CarouselWidgetModel, itemModel: BaseWidgetModel): IMagic<BaseWidgetModel, View>? {
        return MagicViewHelper.createView(itemModel, context)
    }

    override fun afterUpdateItems() {
        mAdapter?.updateItems(items)
    }

    private fun initTimer(duration: Long) {
        mTimer?.dispose()
        mTimer = Observable.interval(duration, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                changePage()
            }
    }

    private fun changePage() {
        Log.i("Sven", "timer")
        mViewPager?.let {
            if (!it.isFakeDragging) {
                it.setCurrentItem(it.currentItem + 1, true)
            }
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mTimer?.dispose()
    }

    class CarouselAdapter(private var pagerItems: List<View>) : PagerAdapter() {
        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 == p1
        }

        override fun getCount(): Int {
            return Int.MAX_VALUE
        }

        fun updateItems(items: List<View>) {
            pagerItems = items
            notifyDataSetChanged()
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            if (pagerItems.isEmpty()) return View(container.context)

            val index = itemIndex(position)
            container.addView(
                pagerItems[index],
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            return pagerItems[index]
        }

        private fun itemIndex(position: Int): Int {
            return if (pagerItems.isNotEmpty()) {
                position % pagerItems.size
            } else {
                0
            }
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            if (pagerItems.isNotEmpty()) {
                container.removeView(pagerItems[itemIndex(position)])
            }
        }
    }
}