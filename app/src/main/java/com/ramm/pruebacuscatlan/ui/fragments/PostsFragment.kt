package com.ramm.pruebacuscatlan.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramm.pruebacuscatlan.R
import com.ramm.pruebacuscatlan.core.domain.dto.post.PostInfo
import com.ramm.pruebacuscatlan.databinding.FragmentPostsBinding
import com.ramm.pruebacuscatlan.ui.adapters.PostAdapter
import com.ramm.pruebacuscatlan.ui.base.Completed
import com.ramm.pruebacuscatlan.ui.base.Error
import com.ramm.pruebacuscatlan.ui.base.Loading
import com.ramm.pruebacuscatlan.ui.base.ViewState
import com.ramm.pruebacuscatlan.ui.interfaces.PostListener
import com.ramm.pruebacuscatlan.ui.utils.afterTextChanged
import com.ramm.pruebacuscatlan.ui.viewmodels.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostsFragment : Fragment(),  PostListener{

    private val navController get() = findNavController()
    private lateinit var binding: FragmentPostsBinding
    private val viewModel: PostViewModel by viewModel()
    private val postAdapter by lazy {
        PostAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPostObserver()
        binding.etSearch.afterTextChanged {
            searchText(it)
        }
    }

    private fun searchText(textSearch: String){
        val listPosts = viewModel.getListPostToSearch(textSearch)
        postAdapter.setItems(listPosts)
    }

    private fun getPostObserver(){
        viewModel.getPosts().observe(viewLifecycleOwner, ::handlerGetPosts)
    }

    private fun handlerGetPosts(viewState: ViewState<List<PostInfo>>){
        when(viewState){
            is Loading -> {}
            is Completed -> {
                configRecyclerView(viewState.data)
            }
            is Error -> {
                Log.e("errorApi", "${viewState.errMessage}")
                Toast.makeText(requireContext(), "Algo salio mal", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun configRecyclerView(listPost: List<PostInfo>){
        postAdapter.setItems(listPost)
        with(binding.rvPosts){
            setHasFixedSize(true)
            //layoutManager = GridLayoutManager(requireContext(), 2,)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = postAdapter
        }
    }

    override fun commentClick(idPost: Int) {
        val bundleComment = bundleOf(CommentsFragment.idPost to idPost)
        navController.navigate(R.id.action_postsFragment_to_commentsPerPostFragment, bundleComment)
    }

    override fun imageClick(idPost: Int) {
        val bundleImage = bundleOf(ImagesFragment.idPost to idPost)
        navController.navigate(R.id.action_postsFragment_to_imagesPerPostFragment, bundleImage)
    }

}