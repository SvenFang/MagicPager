package com.yy.magicpagedemo

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxFragmentActivity

/**
 * Created by Sven on 2019-10-16
 */
class TestListActivity : RxFragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}