package com.yy.magerpage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxFragmentActivity
import com.yy.magerpage.R
import org.mozilla.javascript.VMBridge

/**
 * Created by Sven on 09/05/2019
 */
class MagicActivity : RxFragmentActivity() {

    companion object {
        fun startMagic(
            context: Context,
            type: String,
            key: String
        ) {
            Companion.startMagic(context, type, key, null, null)
        }

        fun startMagic(
            context: Context,
            type: String,
            key: String,
            headersStr: String?,
            paramsStr: String?
        ) {
            val intent = Intent(context, MagicActivity::class.java)
            intent.putExtra(MagicFragment.K_MAGIC_TYPE, type)
            intent.putExtra(MagicFragment.K_MAGIC_KEY, key)
            intent.putExtra(MagicFragment.K_MAGIC_HEADERS, headersStr)
            intent.putExtra(MagicFragment.K_MAGIC_PARAMS, headersStr)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magic)

        val intent = intent
        val type = intent.getStringExtra(MagicFragment.K_MAGIC_TYPE)
        val key = intent.getStringExtra(MagicFragment.K_MAGIC_KEY)
        val headersStr = intent.getStringExtra(MagicFragment.K_MAGIC_HEADERS)
        val paramsStr = intent.getStringExtra(MagicFragment.K_MAGIC_PARAMS)

        supportFragmentManager.beginTransaction()
            .add(R.id.content, MagicFragment.startMagic(type, key, headersStr, paramsStr)).commit()
    }

}