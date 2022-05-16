package com.ramm.pruebacuscatlan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ramm.pruebacuscatlan.core.domain.dto.base.Failure
import com.ramm.pruebacuscatlan.core.domain.dto.base.Success
import com.ramm.pruebacuscatlan.core.domain.dto.post.GetImagesUseCaseEntry
import com.ramm.pruebacuscatlan.core.domain.dto.post.ImageInfo
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetImagesUseCase
import com.ramm.pruebacuscatlan.ui.base.Completed
import com.ramm.pruebacuscatlan.ui.base.Error
import com.ramm.pruebacuscatlan.ui.base.Loading
import com.ramm.pruebacuscatlan.ui.base.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch

class ImageViewModel(
    private val getImagesUseCase: GetImagesUseCase
): ViewModel() {

    fun getImages(idPost: Int) = liveData<ViewState<List<ImageInfo>>>(context = Dispatchers.Main) {
        emit(Loading())
        getImagesUseCase(GetImagesUseCaseEntry(idPost)).catch {
            emit(Error(""))
        }.collect {
            when(it){
                is Success -> emit(Completed(it.data))
                is Failure -> emit(Error(it.dataSourceError.errorMessage, it.dataSourceError.errorCode))
                else -> {}
            }
        }
    }

}