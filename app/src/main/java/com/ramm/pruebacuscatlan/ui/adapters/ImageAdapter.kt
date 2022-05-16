package com.ramm.pruebacuscatlan.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramm.pruebacuscatlan.R
import com.ramm.pruebacuscatlan.core.domain.dto.post.ImageInfo
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
        fun bind(imageLoad: ImageInfo){
            Glide
                .with(itemView.context)
                .load(imageLoad.thumbnailUrl)
                .error(R.drawable.ic_baseline_error_24)
                .into(itemImageBinding.ivImage)
        }
    }
}