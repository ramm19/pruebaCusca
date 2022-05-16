package com.ramm.pruebacuscatlan.core.usecases.post

import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.core.domain.dto.post.CommentInfo
import com.ramm.pruebacuscatlan.core.domain.dto.post.GetCommentsUseCaseEntry
import com.ramm.pruebacuscatlan.core.repositories.PostRepository
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetCommentsUseCase
import kotlinx.coroutines.flow.Flow

class GetCommentsUseCaseImpl(
    private val repository: PostRepository
): GetCommentsUseCase {
    override fun invoke(param: GetCommentsUseCaseEntry) = repository.getComments(param.idPost)
}