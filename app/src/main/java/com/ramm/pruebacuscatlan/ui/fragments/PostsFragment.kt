package com.ramm.pruebacuscatlan.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ramm.pruebacuscatlan.R
import com.ramm.pruebacuscatlan.databinding.FragmentPostsBinding
import com.ramm.pruebacuscatlan.ui.viewmodels.PostViewModel

class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostsBinding
    private val viewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }


}