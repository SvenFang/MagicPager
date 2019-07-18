package com.yy.magerpage.model.json

import com.google.gson.*
import com.yy.magerpage.model.modelenum.WidgetModelType
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.ui.widget.viewmapping.WidgetMapping
import java.lang.reflect.Type
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager

/**
 * Created by Sven on 20/05/2019
 */
object MagicGson {

    val gson: Gson = GsonBuilder()
        .registerTypeAdapter(BaseWidgetModel::class.java, WidgetDeserializerAdapter())
        .registerTypeAdapter(BaseWidgetModel::class.java, WidgetSerializerAdapter())
        .setExclusionStrategies(strategy)
        .create()
}

private val strategy = object : ExclusionStrategy {
    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
        return false
    }

    override fun shouldSkipField(f: FieldAttributes?): Boolean {

        return when (f?.name) {
            "imgRes" -> true
            "actionBlock" -> true
            "loadMoreBlock" -> true
            else -> false
        }
    }

}

class WidgetDeserializerAdapter : JsonDeserializer<BaseWidgetModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BaseWidgetModel? {

        val type = json!!.asJsonObject.get("type").asString
        val item = WidgetMapping.widgetMapping[WidgetModelType.valueOf(type.toString())]

        return context!!.deserialize<BaseWidgetModel>(json, item!!.modelClass.java)
    }
}

class WidgetSerializerAdapter : JsonSerializer<BaseWidgetModel> {
    override fun serialize(src: BaseWidgetModel?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return context!!.serialize(src, WidgetMapping.widgetMapping[src!!.type]!!.modelClass.java)
    }
}