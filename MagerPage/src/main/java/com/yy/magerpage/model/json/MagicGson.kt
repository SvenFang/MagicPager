package com.yy.magerpage.model.json

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.JsonDeserializer
import com.google.gson.JsonSerializer
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonElement
import com.google.gson.JsonDeserializationContext
import com.yy.magerpage.model.widget.BaseWidgetModel
import com.yy.magerpage.ui.widget.viewmapping.WidgetMapping
import java.lang.reflect.Type

/**
 * Created by Sven on 20/05/2019
 * gson解析规则，过滤无效字段
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
            "bindingItem" -> true
            "adapterTypeId" -> true
            else -> false
        }
    }
}

private class WidgetDeserializerAdapter : JsonDeserializer<BaseWidgetModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BaseWidgetModel? {

        val type = json!!.asJsonObject.get("type").asString
        val item = WidgetMapping.widgetMapping[type]

        return context!!.deserialize<BaseWidgetModel>(json, item!!.modelClass.java)
    }
}

private class WidgetSerializerAdapter : JsonSerializer<BaseWidgetModel> {
    override fun serialize(
        src: BaseWidgetModel?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return context!!.serialize(src, WidgetMapping.widgetMapping[src!!.type]!!.modelClass.java)
    }
}