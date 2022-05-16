package com.ramm.pruebacuscatlan.ui.viewmodels

import androidx.lifecycle.liveData
import androidx.lifecycle.ViewModel
import com.ramm.pruebacuscatlan.core.domain.dto.base.Failure
import com.ramm.pruebacuscatlan.core.domain.dto.base.Success
import com.ramm.pruebacuscatlan.core.domain.dto.post.PostInfo
import com.ramm.pruebacuscatlan.core.domain.dto.simple.EmptyUseCaseEntry
import com.ramm.pruebacuscatlan.core.usecases.post.base.GetPostsUseCase
import com.ramm.pruebacuscatlan.ui.base.Completed
import com.ramm.pruebacuscatlan.ui.base.Error
import com.ramm.pruebacuscatlan.ui.base.Loading
import com.ramm.pruebacuscatlan.ui.base.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class PostViewModel(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private var listPostToSearch = listOf<PostInfo>()
    private fun setListPostToSearch(list: List<PostInfo>){
        listPostToSearch = list
    }
    fun getListPostToSearch(textSearch: String) : List<PostInfo>{
        val listPostFounded = mutableListOf<PostInfo>()
        listPostToSearch.map {
            if (it.title.contains(textSearch) || it.body.contains(textSearch))
                listPostFounded.add(it)
        }

        return listPostFounded
    }

    fun getPosts() = liveData<ViewState<List<PostInfo>>>(context = Dispatchers.Main){
        emit(Loading())
        getPostsUseCase(EmptyUseCaseEntry()).catch {
            emit(Error(""))
        }.collect {
            when(it){
                is Success -> {
                    setListPostToSearch(it.data)
                    emit(Completed(it.data))
                }
                is Failure -> {
                    emit(Error(it.dataSourceError.errorMessage, it.dataSourceError.errorCode))
                }
                else -> {}
            }
        }
    }

}