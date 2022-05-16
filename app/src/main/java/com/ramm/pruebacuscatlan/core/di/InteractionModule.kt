package com.ramm.pruebacuscatlan.core.di

import com.ramm.pruebacuscatlan.core.usecases.post.GetCommentsUseCaseImpl
import com.ramm.pruebacuscatlan.core.usecases.post.GetImagesUseCaseImpl
import com.ramm.pruebacuscatlan.core.usecases.post.GetPostsUseCaseImpl
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetCommentsUseCase
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetImagesUseCase
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetPostsUseCase
import org.koin.dsl.module

val interactionModule = module {
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }
    factory<GetCommentsUseCase> { GetCommentsUseCaseImpl(get()) }
    factory<GetImagesUseCase> { GetImagesUseCaseImpl(get()) }
}