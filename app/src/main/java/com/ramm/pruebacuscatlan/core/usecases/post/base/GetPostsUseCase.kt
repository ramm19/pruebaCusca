package com.ramm.pruebacuscatlan.core.usecases.post.base

import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.core.domain.dto.post.PostInfo
import com.ramm.pruebacuscatlan.core.domain.dto.simple.EmptyUseCaseEntry
import com.ramm.pruebacuscatlan.core.usecases.base.FlowableUseCase
import kotlinx.coroutines.flow.Flow

interface GetPostsUseCase: FlowableUseCase<EmptyUseCaseEntry, List<PostInfo>> {
    override fun invoke(param: EmptyUseCaseEntry): Flow<Result<List<PostInfo>>>
}