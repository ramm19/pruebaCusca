package com.ramm.pruebacuscatlan.framework.data

import com.ramm.pruebacuscatlan.core.domain.dto.post.CommentInfo
import com.ramm.pruebacuscatlan.framework.common.DomainMapper

data class CommentResponse(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
): DomainMapper<CommentInfo>{
    override fun mapToDomainModel() = CommentInfo(postId, id, name, email, body)

}
