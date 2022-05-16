package com.ramm.pruebacuscatlan.core.repositories

import com.ramm.pruebacuscatlan.core.domain.dto.post.CommentInfo
import com.ramm.pruebacuscatlan.core.domain.dto.post.ImageInfo
import com.ramm.pruebacuscatlan.core.domain.dto.post.PostInfo
import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<Result<List<PostInfo>>>
    fun getComments(idPost: Int): Flow<Result<List<CommentInfo>>>
    fun getImages(idPost: Int): Flow<Result<List<ImageInfo>>>
}