package com.ramm.pruebacuscatlan.core.usecases.post

import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.core.domain.dto.post.GetImagesUseCaseEntry
import com.ramm.pruebacuscatlan.core.domain.dto.post.ImageInfo
import com.ramm.pruebacuscatlan.core.repositories.PostRepository
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetImagesUseCase
import kotlinx.coroutines.flow.Flow

class GetImagesUseCaseImpl(
    private val repository: PostRepository
): GetImagesUseCase {
    override fun invoke(param: GetImagesUseCaseEntry) = repository.getImages(param.idPost)
}