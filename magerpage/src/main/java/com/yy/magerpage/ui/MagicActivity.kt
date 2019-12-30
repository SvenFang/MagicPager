package com.yy.magerpage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxFragmentActivity
import com.yy.magerpage.Constant
import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.R
import com.yy.magerpage.model.container.MagicPagerModel
import com.yy.magerpage.model.request.PageRequestData

/**
 * Created by Sven on 09/05/2019
 */
class MagicActivity : RxFragmentActivity() {

    companion object {
        fun startMagic(
            context: Context,
            requestData: PageRequestData
        ) {
            val intent = Intent(context, MagicActivity::class.java)
            intent.putExtra(Constant.K_MAGIC_REQUEST_DATA, requestData)
            context.startActivity(intent)
        }

        fun startMagic(
            context: Context,
            model: MagicPagerModel
        ) {
            val intent = Intent(context, MagicActivity::class.java)
            intent.putExtra(Constant.K_MAGIC_MODEL, model)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magic)

        val intent = intent
        val requestData = intent.getSerializableExtra(Constant.K_MAGIC_REQUEST_DATA)

        val model =
            intent.getSerializableExtra(Constant.K_MAGIC_MODEL)

        val magicFragment: MagicFragment?

        magicFragment = when {
            model is MagicPagerModel -> MagicFragment.startMagic(model)
            requestData is PageRequestData -> MagicFragment.startMagic(requestData)
            null != MagicPagerManager.get().errorPageProvider -> MagicFragment.startMagic(
                MagicPagerManager.get().errorPageProvider!!.getErrorPage(
                    null
                )
            )
            else -> MagicFragment.startMagic(MagicPagerModel())
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.content, magicFragment).commit()
    }
}