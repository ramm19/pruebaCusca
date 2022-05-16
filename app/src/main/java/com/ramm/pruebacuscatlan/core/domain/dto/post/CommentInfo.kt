package com.ramm.pruebacuscatlan.core.domain.dto.post

data class CommentInfo(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)