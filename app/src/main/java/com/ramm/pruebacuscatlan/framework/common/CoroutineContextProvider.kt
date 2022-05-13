package com.ramm.pruebacuscatlan.framework.common

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

//todo eliminar si no ocupo
open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
}