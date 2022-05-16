package com.ramm.pruebacuscatlan.framework.common

import android.util.Log
import com.google.gson.Gson
import com.ramm.pruebacuscatlan.core.domain.dto.base.DataSourceError
import com.ramm.pruebacuscatlan.core.domain.dto.base.Failure
import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.core.domain.dto.base.Success
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response
import java.io.IOException

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(action)
    return this
}

inline fun <T : Any> Response<T>.onFailure(action: (DataSourceError) -> Unit) {

}

inline fun <reified T : List<U>, reified U : DomainMapper<R>, R : Any> Response<T>.getData(): Result<List<R>> {

    try {
        onSuccess {
            val listDomain = it.map { listResponse ->
                listResponse.mapToDomainModel()
            }
            return Success(listDomain)
        }
        onFailure {
            Log.e("errorApi", "${it.errorMessage}")
            return Failure(it)
        }
        return Failure(DataSourceError(Throwable("error")))
    } catch (e: IOException) {
        return Failure(DataSourceError(Throwable("error")))
    }
}
