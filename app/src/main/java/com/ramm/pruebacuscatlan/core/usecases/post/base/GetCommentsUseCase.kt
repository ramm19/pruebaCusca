package com.ramm.pruebacuscatlan.core.usecases.post.base

import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.core.domain.dto.post.CommentInfo
import com.ramm.pruebacuscatlan.core.domain.dto.post.GetCommentsUseCaseEntry
import com.ramm.pruebacuscatlan.core.usecases.base.FlowableUseCase
import kotlinx.coroutines.flow.Flow

interface GetCommentsUseCase: FlowableUseCase<GetCommentsUseCaseEntry, List<CommentInfo>> {
    override fun invoke(param: GetCommentsUseCaseEntry): Flow<Result<List<CommentInfo>>>
}