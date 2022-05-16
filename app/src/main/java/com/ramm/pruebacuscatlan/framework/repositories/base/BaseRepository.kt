package com.ramm.pruebacuscatlan.framework.repositories.base

import com.ramm.pruebacuscatlan.core.domain.dto.base.DataSourceError
import com.ramm.pruebacuscatlan.core.domain.dto.base.Failure
import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.framework.common.DomainMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

abstract class BaseRepository {

    protected suspend fun<N: Any> fetchData(
        dataProvider: suspend () -> Result<N>
    ): Result<N> {
        //todo hacer validacion de internet
        return withContext(Dispatchers.IO){
            dataProvider()
        }
    }

    protected fun <N: Any, E: DomainMapper<N>> fetchDataFlow(
        apiDataListProvider: suspend () -> Result<List<N>>
    ): Flow<Result<List<N>>>{
        return flow {
            emit(apiDataListProvider())
        }.flowOn(Dispatchers.IO)
            .catch { emit(Failure(DataSourceError(Throwable(it)))) }
    }
}