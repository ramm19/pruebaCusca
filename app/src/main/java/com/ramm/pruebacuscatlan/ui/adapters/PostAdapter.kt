package com.ramm.pruebacuscatlan.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramm.pruebacuscatlan.core.domain.dto.post.PostInfo
import com.ramm.pruebacuscatlan.databinding.ItemPostBinding
import com.ramm.pruebacuscatlan.ui.interfaces.PostListener

class PostAdapter(
    private val listener: PostListener
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var postList = listOf<PostInfo>()

    fun setItems(items: List<PostInfo>){
        postList = listOf()
        postList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(postList[position])

    override fun getItemCount() = postList.size

    class ViewHolder(
        private val itemPostBinding: ItemPostBinding,
        private val listener: PostListener
    ): RecyclerView.ViewHolder(itemPostBinding.root){
        fun bind(post: PostInfo){
            with(itemPostBinding){
                tvTitle.text = post.title
                tvMessage.text = post.body

                ivComment.setOnClickListener {
                    listener.commentClick(post.id)
                }

                ivImages.setOnClickListener {
                    listener.imageClick(post.id)
                }
            }
        }
    }
}