package com.ramm.pruebacuscatlan.framework.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser

fun initGson(setDateFormat: String, excludeExpose: Boolean = true): Gson =
    GsonBuilder().setDateFormat(setDateFormat).apply {
        if (excludeExpose) excludeFieldsWithoutExposeAnnotation()
    }.create()

fun jsonObjectFromString(data: String, setDateFormat: String = "yyyy-MM-dd"): JsonElement =
    JsonParser.parseString(data)

fun jsonObjectFromObject(data: Any, excludeExpose: Boolean = true): JsonElement =
    jsonObjectFromString(jsonStringFromObject(data, excludeExpose = excludeExpose))

fun jsonStringFromObject(
    data: Any,
    setDateFormat: String = "yyyy-MM-dd",
    excludeExpose: Boolean = true,
): String =
    initGson(setDateFormat, excludeExpose).toJson(data)