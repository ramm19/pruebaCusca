package com.ramm.pruebacuscatlan.ui.viewmodels

import androidx.lifecycle.liveData
import androidx.lifecycle.ViewModel
import com.ramm.pruebacuscatlan.core.domain.dto.PostInfo
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class PostViewModel : ViewModel() {

    fun getPosts() = liveData<PostInfo>(context = Dispatchers.Main){

    }

}