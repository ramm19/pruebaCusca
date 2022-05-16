package com.ramm.pruebacuscatlan.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramm.pruebacuscatlan.core.domain.dto.post.CommentInfo
import com.ramm.pruebacuscatlan.databinding.FragmentCommentsBinding
import com.ramm.pruebacuscatlan.ui.adapters.CommentAdapter
import com.ramm.pruebacuscatlan.ui.base.Completed
import com.ramm.pruebacuscatlan.ui.base.Error
import com.ramm.pruebacuscatlan.ui.base.Loading
import com.ramm.pruebacuscatlan.ui.base.ViewState
import com.ramm.pruebacuscatlan.ui.utils.afterTextChanged
import com.ramm.pruebacuscatlan.ui.viewmodels.CommentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommentsFragment : Fragment() {

    private val navController get() = findNavController()
    private lateinit var binding: FragmentCommentsBinding
    private val viewModel : CommentViewModel by viewModel()
    private lateinit var commentAdapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getComments(arguments?.getInt(idPost) ?: 0)
        binding.ivBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.etSearch.afterTextChanged {
            searchText(it)
        }
    }

    private fun searchText(search: String){
        val listCommentsFound = viewModel.getListCommentToSearch(search)
        commentAdapter.setItems(listCommentsFound)
    }

    private fun getComments(idPost: Int){
        viewModel.getComments(idPost).observe(viewLifecycleOwner, ::handlerGetComments)
    }

    private fun handlerGetComments(viewState: ViewState<List<CommentInfo>>){
        when(viewState){
            is Loading -> {}
            is Completed -> {
                configRecyclerView(viewState.data)
            }
            is Error -> {}
        }
    }

    private fun configRecyclerView(listComments: List<CommentInfo>){
        commentAdapter = CommentAdapter()
        commentAdapter.setItems(listComments)
        with(binding.rvComments){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = commentAdapter
        }
    }

    companion object{
        const val idPost = "idPost"
    }
}