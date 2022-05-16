package com.ramm.pruebacuscatlan.core.usecases.base

import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import kotlinx.coroutines.flow.Flow

interface FlowableUseCase<T: Any, R: Any> {
    operator fun invoke(param: T): Flow<Result<R>>
}