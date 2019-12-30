package com.yy.magerpage.script

import android.content.Context
import com.yy.magerpage.util.MLog
import java.util.WeakHashMap


/**
 * Created by Sven on 2019-10-25
 */
class MagicScriptManager {

    private val pagerScripts: WeakHashMap<Context, MagicScript> = WeakHashMap()
    //计数器
    private val scriptsCount: WeakHashMap<Context, Int> = WeakHashMap()

    companion object {
        private const val TAG = "MagicScriptManager"
        private var instance: MagicScriptManager? = null
            get() {
                if (field == null) {
                    field = MagicScriptManager()
                }
                return field
            }

        @Synchronized
        fun get(): MagicScriptManager {
            return instance!!
        }
    }

    fun enter(context: Context) {
        if (null == pagerScripts[context]) {
            val script = MagicScript()
            script.enter(context)
            pagerScripts[context] = script
            scriptsCount[context] = 0
            MLog.i(TAG, "enter")
        }

        val count = scriptsCount[context]
        scriptsCount[context] = count?.plus(1)
    }

    fun exit(context: Context) {

        if (null != scriptsCount[context]) {
            val count = scriptsCount[context]
            scriptsCount[context] = count?.minus(1)

            if (scriptsCount[context] == 0) {
                scriptsCount.remove(context)
                pagerScripts[context]?.exit()
                pagerScripts.remove(context)
                MLog.i(TAG, "exit")
            }
        }
    }

    fun getPagerScript(context: Context): MagicScript? {
        return pagerScripts[context]
    }
}