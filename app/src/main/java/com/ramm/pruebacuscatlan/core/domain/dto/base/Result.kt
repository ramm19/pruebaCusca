package com.ramm.pruebacuscatlan.core.domain.dto.base

import org.json.JSONObject

sealed class Result<out T : Any>

data class Success<out T : Any>(
    val data: T
) : Result<T>()

data class Failure(val dataSourceError: DataSourceError) : Result<Nothing>()
object Empty : Result<Nothing>()

class DataSourceError(
    var throwable: Throwable,
    val errorCode: Int = 0,
    val errorBody: JSONObject? = null
) {
    val errorMessage = throwable.localizedMessage ?: ""
}

inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Success) action(data)
    return this
}

inline fun <T : Any> Result<T>.onFailure(action: (DataSourceError) -> Unit) {
    if (this is Failure) action(dataSourceError)
}
