package com.ramm.pruebacuscatlan.framework.data

import com.ramm.pruebacuscatlan.core.domain.dto.post.ImageInfo
import com.ramm.pruebacuscatlan.framework.common.DomainMapper

data class ImageResponse(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
): DomainMapper<ImageInfo>{
    override fun mapToDomainModel() = ImageInfo(albumId, id, title, url, thumbnailUrl)

}
