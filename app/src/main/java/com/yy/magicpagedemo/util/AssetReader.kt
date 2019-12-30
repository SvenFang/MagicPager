package com.yy.magicpagedemo.util

import android.content.Context
import android.util.Log
import com.yy.magerpage.model.container.MagicPagerModel
import com.yy.magerpage.model.json.MagicGson
import com.yy.magicpagedemo.test.Test
import com.yy.magicpagedemo.test.TestAd
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

/**
 * Created by Sven on 2019-06-28
 */
object AssetReader {
    fun getAssetStr(context: Context, fileName: String): String {
        val assetManager = context.assets
        val stringBuilder = StringBuffer()

        try {
            val bufferedReader = BufferedReader(InputStreamReader(assetManager.open(fileName), "utf-8"))
            bufferedReader.readLines().forEach { s ->
                stringBuilder.append(s)
            }
        } catch (e: Exception) {
            Log.e("Sven", "exception", e)
        }

        return stringBuilder.toString()
    }

    fun getTextString(): String {
        return MagicGson.gson.toJson(Test.getTestModel())
    }

    fun getTextModel(): MagicPagerModel {
        return Test.getTestModel()
    }

    fun getAdModel(): MagicPagerModel {
        return TestAd.getTestModel()
    }
}