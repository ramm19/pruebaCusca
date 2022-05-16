package com.ramm.pruebacuscatlan.ui.di

import com.ramm.pruebacuscatlan.ui.viewmodels.CommentViewModel
import com.ramm.pruebacuscatlan.ui.viewmodels.ImageViewModel
import com.ramm.pruebacuscatlan.ui.viewmodels.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { PostViewModel(get()) }
    viewModel { CommentViewModel(get()) }
    viewModel { ImageViewModel(get()) }
}