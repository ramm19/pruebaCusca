package com.ramm.pruebacuscatlan.ui.base

import org.json.JSONObject

sealed class ViewState<out T : Any>
class Completed<out T : Any>(val data: T) :
    ViewState<T>()

class Error<out T : Any>(val error: Throwable? = null) : ViewState<T>() {

    var errMessage: String
        private set
    var status: Int?
        private set
    var errorBody: JSONObject?
        private set

    init {
        this.errMessage = error?.localizedMessage ?: ""
        this.status = null
        this.errorBody = null
    }

    constructor(errMessage: String, status: Int? = null, errorBody: JSONObject? = null) : this(
        Throwable(errMessage)
    ) {
        this.errMessage = errMessage
        this.status = status
        this.errorBody = errorBody
    }
}

class Loading<out T : Any> : ViewState<T>()