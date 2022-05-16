package com.ramm.pruebacuscatlan.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramm.pruebacuscatlan.core.domain.dto.post.CommentInfo
import com.ramm.pruebacuscatlan.databinding.ItemCommentLeftBinding
import com.ramm.pruebacuscatlan.databinding.ItemCommentRightBinding

class CommentAdapter: RecyclerView.Adapter<CommentAdapter.BaseViewHolder>() {

    private var commentList = listOf<CommentInfo>()

    fun setItems(items: List<CommentInfo>){
        commentList = listOf()
        commentList = items
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (position%2){
            0 -> 0
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        when(viewType){
            0 -> {
                ViewHolderRight(ItemCommentRightBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> {
                ViewHolderLeft(ItemCommentLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(commentList[position])

    override fun getItemCount() = commentList.size

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        abstract fun bind(comment: CommentInfo)
    }

    class ViewHolderRight(
        private val itemCommentRightBinding: ItemCommentRightBinding
    ): BaseViewHolder(itemCommentRightBinding.root){
        override fun bind(comment: CommentInfo) {
            with(itemCommentRightBinding){
                tvMessage.text = comment.body
                tvEmail.text = comment.email
            }
        }
    }

    class ViewHolderLeft(
        private val itemCommentLeftBinding: ItemCommentLeftBinding
    ): BaseViewHolder(itemCommentLeftBinding.root){
        override fun bind(comment: CommentInfo) {
            with(itemCommentLeftBinding){
                tvMessage.text = comment.body
                tvEmail.text = comment.email
            }
        }
    }
}