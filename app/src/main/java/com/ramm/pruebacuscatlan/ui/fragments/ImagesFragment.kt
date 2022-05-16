package com.ramm.pruebacuscatlan.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ramm.pruebacuscatlan.core.domain.dto.post.ImageInfo
import com.ramm.pruebacuscatlan.databinding.FragmentImagesBinding
import com.ramm.pruebacuscatlan.ui.adapters.ImageAdapter
import com.ramm.pruebacuscatlan.ui.base.Completed
import com.ramm.pruebacuscatlan.ui.base.Error
import com.ramm.pruebacuscatlan.ui.base.Loading
import com.ramm.pruebacuscatlan.ui.base.ViewState
import com.ramm.pruebacuscatlan.ui.viewmodels.ImageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ImagesFragment : Fragment() {

    private val navController get() = findNavController()
    private lateinit var binding: FragmentImagesBinding
    private val viewModel : ImageViewModel by viewModel()
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getImagesObserver()
        binding.ivBack.setOnClickListener {
            navController.popBackStack()
        }
    }

    private fun getImagesObserver(){
        viewModel.getImages(1).observe(viewLifecycleOwner, ::handlerGetImages)
    }

    private fun handlerGetImages(viewState: ViewState<List<ImageInfo>>){
        when(viewState){
            is Loading -> {}
            is Completed -> {
                configRecyclerView(viewState.data)
            }
            is Error -> {}
        }
    }

    private fun configRecyclerView(listImages: List<ImageInfo>){
        imageAdapter = ImageAdapter()
        imageAdapter.setItems(listImages)
        with(binding.rvImages){
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = imageAdapter
        }
    }
}