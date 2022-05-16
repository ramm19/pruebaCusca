package com.ramm.pruebacuscatlan.framework.data

import com.ramm.pruebacuscatlan.core.domain.dto.post.PostInfo
import com.ramm.pruebacuscatlan.framework.common.DomainMapper

data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
): DomainMapper<PostInfo>{
    override fun mapToDomainModel() = PostInfo (userId, id, title, body)

}
