package com.ramm.pruebacuscatlan.core.usecases.post

import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.core.domain.dto.post.PostInfo
import com.ramm.pruebacuscatlan.core.domain.dto.simple.EmptyUseCaseEntry
import com.ramm.pruebacuscatlan.core.repositories.PostRepository
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetPostsUseCase
import kotlinx.coroutines.flow.Flow

class GetPostsUseCaseImpl(
    private val repository: PostRepository
): GetPostsUseCase {
    override fun invoke(param: EmptyUseCaseEntry) = repository.getPosts()
}