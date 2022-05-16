package com.ramm.pruebacuscatlan.framework.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import java.io.StringReader

fun initGson(setDateFormat: String, excludeExpose: Boolean = false): Gson =
    GsonBuilder().setDateFormat(setDateFormat).apply {
        if (excludeExpose) excludeFieldsWithoutExposeAnnotation()
    }.create()

fun jsonObjectFromString(data: String): JsonElement {
    val jsonReader = JsonReader(StringReader(data))
    jsonReader.isLenient = true
    return JsonParser.parseReader(jsonReader)
}
//fun jsonObjectFromString(data: String): JsonElement =
    //JsonParser.parseString(data)

fun jsonObjectFromObject(data: Any, excludeExpose: Boolean = false): JsonElement =
    jsonObjectFromString(jsonStringFromObject(data, excludeExpose = excludeExpose))

fun jsonStringFromObject(
    data: Any,
    setDateFormat: String = "yyyy-MM-dd",
    excludeExpose: Boolean = true,
): String =
    initGson(setDateFormat, excludeExpose).toJson(data)