package com.ramm.pruebacuscatlan.framework.service

import com.ramm.pruebacuscatlan.framework.data.CommentResponse
import com.ramm.pruebacuscatlan.framework.data.ImageResponse
import com.ramm.pruebacuscatlan.framework.data.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("https://jsonplaceholder.typicode.com/posts")
    suspend fun getPosts(): Response<List<PostResponse>>

    @GET("https://jsonplaceholder.typicode.com/posts/{idpost}/comments")
    suspend fun getComments(
        @Path(value = "idpost", encoded = true) postId: String
    ): Response<List<CommentResponse>>

    @GET("https://jsonplaceholder.typicode.com/posts/{idpost}/photos")
    suspend fun getImages(
        @Path(value = "idpost", encoded = true) postId: String
    ): Response<List<ImageResponse>>
}