package com.ramm.pruebacuscatlan.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.ramm.pruebacuscatlan.core.domain.dto.ImageInfo
import com.ramm.pruebacuscatlan.databinding.ItemCommentRightBinding
import com.ramm.pruebacuscatlan.databinding.ItemImageBinding

class ImageAdapter: RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private var imageList = listOf<ImageInfo>()

    fun setItems(items: List<ImageInfo>){
        imageList = listOf()
        imageList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(imageList[position])

    override fun getItemCount() = imageList.size

    class ViewHolder(
        private val itemImageBinding: ItemImageBinding
    ): RecyclerView.ViewHolder(itemImageBinding.root){
        fun bind(image: ImageInfo){
            itemImageBinding.ivImage.setImageURI(image.thumbnailUrl.toUri())
        }
    }
}