package com.ramm.pruebacuscatlan.core.usecases.post.base

import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.core.domain.dto.post.GetImagesUseCaseEntry
import com.ramm.pruebacuscatlan.core.domain.dto.post.ImageInfo
import com.ramm.pruebacuscatlan.core.usecases.base.FlowableUseCase
import kotlinx.coroutines.flow.Flow

interface GetImagesUseCase: FlowableUseCase<GetImagesUseCaseEntry, List<ImageInfo>> {
    override fun invoke(param: GetImagesUseCaseEntry): Flow<Result<List<ImageInfo>>>
}