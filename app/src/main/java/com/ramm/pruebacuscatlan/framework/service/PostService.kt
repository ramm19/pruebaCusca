package com.ramm.pruebacuscatlan.framework.service

import com.ramm.pruebacuscatlan.core.domain.dto.CommentInfo
import com.ramm.pruebacuscatlan.core.domain.dto.ImageInfo
import com.ramm.pruebacuscatlan.core.domain.dto.PostInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("https://jsonplaceholder.typicode.com/posts")
    suspend fun getPosts(): Response<List<PostInfo>>

    @GET("https://jsonplaceholder.typicode.com/posts/{idpost}/comments")
    suspend fun getComments(
        @Path(value = "idpost", encoded = true) postId: String
    ): Response<List<CommentInfo>>

    @GET("https://jsonplaceholder.typicode.com/posts/{idpost}/photos")
    suspend fun getImages(
        @Path(value = "idpost", encoded = true) postId: String
    ): Response<List<ImageInfo>>
}