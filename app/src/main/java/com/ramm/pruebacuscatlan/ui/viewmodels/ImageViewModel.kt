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
import kotlinx.coroutines.flow.collect

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





        /*emit(Loading())
        val listImage = listOf(
            ImageInfo(
                1,1,"", "", "https://via.placeholder.com/150/771796"
            ),
            ImageInfo(
                1,1,"", "", "https://via.placeholder.com/150/d32776"
            ),
            ImageInfo(
                1,1,"", "", "https://via.placeholder.com/150/810b14"
            )
        )
        emit(Completed(listImage))*/
    }

}