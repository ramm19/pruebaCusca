package com.ramm.pruebacuscatlan.framework.repositories

import com.ramm.pruebacuscatlan.core.domain.dto.post.PostInfo
import com.ramm.pruebacuscatlan.core.domain.dto.base.Result
import com.ramm.pruebacuscatlan.core.repositories.PostRepository
import com.ramm.pruebacuscatlan.framework.common.getData
import com.ramm.pruebacuscatlan.framework.repositories.base.BaseRepository
import com.ramm.pruebacuscatlan.framework.service.PostService
import kotlinx.coroutines.flow.Flow


class PostRepositoryImpl(
    private val postService: PostService
): BaseRepository(), PostRepository {

    override fun getPosts(): Flow<Result<List<PostInfo>>> = fetchDataFlow(apiDataListProvider = {
        postService.getPosts().getData()
    })

    override fun getComments(idPost: Int) = fetchDataFlow(apiDataListProvider = {
        postService.getComments(idPost.toString()).getData()
    })

    override fun getImages(idPost: Int) = fetchDataFlow(apiDataListProvider = {
        postService.getImages(idPost.toString()).getData()
    })
}
