package com.yy.magerpage.script

import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.util.MLog
import org.mozilla.javascript.Context
import org.mozilla.javascript.Function
import org.mozilla.javascript.ScriptableObject
import java.lang.Exception
import java.lang.ref.WeakReference

/**
 * Created by Sven on 2019-06-28
 */
class MagicScript {
    private var jsContext: Context? = null
    private var scope: ScriptableObject? = null
    private var contextReference: WeakReference<android.content.Context>? = null

    companion object {
        private const val TAG = "[MagicScript]"

        fun call(type: String, key: String, params: String?): String {
            return "native.call(\"$type\",\"$key\",\"$params\")"
        }

        fun log(tag: String, info: String): String {
            return "native.log(\"$tag\",\"$info\")"
        }
    }

    fun enter(context: android.content.Context) {
        contextReference = WeakReference(context)
        jsContext = Context.enter()
        jsContext?.languageVersion = Context.VERSION_ES6
        jsContext?.optimizationLevel = -1
        scope = jsContext?.initStandardObjects()
        addProperty("native", this)
        MLog.i(TAG, "start")
    }

    fun exit() {
        MLog.i(TAG, "clean")
        try {
            Context.exit()
        } catch (e: Exception) {
            MLog.e(TAG, "context exit exception", e)
        }
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
            obj = jsContext?.evaluateString(scope, str, "magicJs", 1, null)
        } catch (e: Exception) {
            MLog.e(TAG, "js exception", e)
        }

        return obj
    }

    /**
     * 响应js调用方法
     */
    fun call(type: String, key: String) {
        call(type, key, null)
    }

    fun call(type: String, key: String, params: String?) {
        call(type, key, params, null)
    }

    fun call(type: String, key: String, params: String?, callBack: Any?) {
        MLog.i(TAG, "call native type=$type, key=$key, params=$params")
        val result = MagicPagerManager.get().scriptBridge.invoke(
            contextReference?.get(),
            type,
            key,
            params
        )
        if (callBack is Function) {
            callBack.call(jsContext, scope, scope, arrayOf(result))
        }
    }

    fun log(tag: String, info: String) {
        MLog.i(tag, "print $info")
    }

    fun testJs(): String {
        return "native.call('type','key','params',function(result) {\n" +
                "native.log('Sven', 'fromJs:' + result)\n" +
                "   })"
    }
}