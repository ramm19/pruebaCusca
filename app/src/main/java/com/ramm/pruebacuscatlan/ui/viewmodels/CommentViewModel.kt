package com.ramm.pruebacuscatlan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ramm.pruebacuscatlan.core.domain.dto.base.Failure
import com.ramm.pruebacuscatlan.core.domain.dto.base.Success
import com.ramm.pruebacuscatlan.core.domain.dto.post.CommentInfo
import com.ramm.pruebacuscatlan.core.domain.dto.post.GetCommentsUseCaseEntry
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetCommentsUseCase
import com.ramm.pruebacuscatlan.ui.base.Completed
import com.ramm.pruebacuscatlan.ui.base.Error
import com.ramm.pruebacuscatlan.ui.base.Loading
import com.ramm.pruebacuscatlan.ui.base.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class CommentViewModel(
    private val getCommentsUseCase: GetCommentsUseCase
): ViewModel() {
    fun getComments(idPost: Int) = liveData<ViewState<List<CommentInfo>>>(context = Dispatchers.Main) {
        emit(Loading())
        getCommentsUseCase(GetCommentsUseCaseEntry(idPost)).catch {
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