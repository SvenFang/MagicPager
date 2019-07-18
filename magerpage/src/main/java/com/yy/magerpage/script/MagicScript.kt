package com.yy.magerpage.script

import android.util.Log
import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.util.MLog
import org.mozilla.javascript.Context
import org.mozilla.javascript.Function
import org.mozilla.javascript.ScriptableObject
import java.lang.Exception
import com.google.gson.reflect.TypeToken
import com.yy.magerpage.model.json.MagicGson


/**
 * Created by Sven on 2019-06-28
 */
class MagicScript {
    private val context: android.content.Context?
    private var jsContext: Context
    private val scope: ScriptableObject


    constructor(context: android.content.Context?) {
        this.context = context
        jsContext = Context.enter()
        jsContext.languageVersion = Context.VERSION_ES6
        jsContext.optimizationLevel = -1
        scope = jsContext.initStandardObjects()
        addProperty("native", this)
        MLog.e("magic", "start")
    }

    fun clean() {
        MLog.e("magic", "clean")
        Context.exit()
    }

    /**
     * 注入数据到js
     */
    private fun addProperty(name: String, value: Any) {
        ScriptableObject.putProperty(
            scope,
            name,
            Context.javaToJS(value, scope)
        )
    }

    fun evaluate(str: String): Any? {
        var obj: Any? = null

        try {
            obj = jsContext.evaluateString(scope, str, "magicJs", 1, null)
        } catch (e: Exception) {
            MLog.e("Sven", "js exception", e)
        }

        return obj
    }

    fun jsCallNative(type: String, key: String, headers: String?, params: String?, callBack: Any?) {
        MLog.i("Sven", "call native type=$type, key=$key, headers=$headers, params=$params")
        val jsonClass = object : TypeToken<HashMap<String, Any>>() {
        }.type

        val headerMap: HashMap<String, Any>? = MagicGson.gson.fromJson(headers, jsonClass)
        val paramMap: HashMap<String, Any>? = MagicGson.gson.fromJson(params, jsonClass)

        val result = MagicPagerManager.get().getScriptBridge().invoke(
            context,
            type,
            key,
            headerMap,
            paramMap
        )
        if (callBack is Function) {
            callBack.call(jsContext, scope, scope, arrayOf(result))
        }
    }

    fun nativeLog(tag: String, info: String) {
        MLog.i(tag, "print $info")
    }

    fun testJs(): String {
        return "native.jsCallNative('type','key','header','params',function(result) {\n" +
                "native.nativeLog('Sven', 'fromJs:' + result)\n" +
                "   })"
    }

}