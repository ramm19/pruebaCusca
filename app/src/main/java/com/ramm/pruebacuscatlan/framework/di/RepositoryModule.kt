package com.ramm.pruebacuscatlan.framework.di

import com.ramm.pruebacuscatlan.core.repositories.PostRepository
import com.ramm.pruebacuscatlan.framework.repositories.PostRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostRepository> { PostRepositoryImpl(get()) }
}