package com.example.mobuloustask.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mobuloustask.R
import com.example.mobuloustask.adapter.AlbumsAdapter
import com.example.mobuloustask.adapter.PhotosAdapter
import com.example.mobuloustask.databinding.FragmentPhotosBinding
import com.example.mobuloustask.model.AlbumsListResponse
import com.example.mobuloustask.model.PhotosListResponse
import com.example.mobuloustask.utils.ErrorUtil
import com.example.mobuloustask.utils.NetworkUtils
import com.example.mobuloustask.utils.ProgressDialogUtil
import com.example.mobuloustask.utils.showToast
import com.example.mobuloustask.viewmodel.PhotosListViewModel

class PhotosFragment : Fragment() {
private lateinit var binding: FragmentPhotosBinding
private lateinit var photosViewModel : PhotosListViewModel
private lateinit var adapter:PhotosAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhotosBinding.inflate(layoutInflater)
        photosViewModel = ViewModelProvider(requireActivity())[PhotosListViewModel::class.java]
getPhotos()
        hitPhotosList()
        return binding.root
    }
    private fun getPhotos() {
        photosViewModel.photosListResponse.observe(requireActivity(), androidx.lifecycle.Observer {
            adapter = PhotosAdapter(requireContext(),it as ArrayList<PhotosListResponse.PhotosListResponseItem>)
            binding.photosRecycler.adapter = adapter


        })
        photosViewModel.errorPost.observe(requireActivity(), androidx.lifecycle.Observer {
            ProgressDialogUtil.getInstance().hideProgress()
           // ErrorUtil.handlerGeneralError(requireActivity(), binding.photosRecycler, it)
        })
        photosViewModel.progressPost.observe(requireActivity(), androidx.lifecycle.Observer {
            if (it) {
                ProgressDialogUtil.getInstance().showProgress(requireActivity(), true)
            } else {
                ProgressDialogUtil.getInstance().hideProgress()
            }
        })
    }
    fun hitPhotosList() {
        if (NetworkUtils.isInternetAvailable(requireActivity())) {

            photosViewModel.hitPhotosList()

        } else {
            showToast("Please check your internet",requireContext())
        }
    }

}