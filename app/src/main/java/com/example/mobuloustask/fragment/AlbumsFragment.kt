package com.example.mobuloustask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobuloustask.R
import com.example.mobuloustask.adapter.AlbumsAdapter
import com.example.mobuloustask.adapter.PostAdapter
import com.example.mobuloustask.databinding.FragmentAlbumsBinding
import com.example.mobuloustask.model.AlbumsListResponse
import com.example.mobuloustask.model.PostListResponse
import com.example.mobuloustask.utils.ErrorUtil
import com.example.mobuloustask.utils.NetworkUtils
import com.example.mobuloustask.utils.ProgressDialogUtil
import com.example.mobuloustask.utils.showToast
import com.example.mobuloustask.viewmodel.AlbumsListViewModel
import com.example.mobuloustask.viewmodel.PostViewModel

class AlbumsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding
    private lateinit var albumsListViewModel: AlbumsListViewModel
    private lateinit var adapter : AlbumsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumsBinding.inflate(layoutInflater)
        albumsListViewModel = ViewModelProvider(requireActivity())[AlbumsListViewModel::class.java]
        getAlbums()
        hitAlbumsList()
        return binding.root
    }

    private fun getAlbums() {
        albumsListViewModel.albumsListResponse.observe(requireActivity(), androidx.lifecycle.Observer {
            adapter = AlbumsAdapter(requireContext(),it as ArrayList<AlbumsListResponse.AlbumsListResponseItem>)
            binding.albumsRecycler.adapter = adapter


        })
        albumsListViewModel.errorPost.observe(requireActivity(), androidx.lifecycle.Observer {
            ProgressDialogUtil.getInstance().hideProgress()
          //  ErrorUtil.handlerGeneralError(requireActivity(), binding.albumsRecycler, it)
        })
        albumsListViewModel.progressPost.observe(requireActivity(), androidx.lifecycle.Observer {
            if (it) {
                ProgressDialogUtil.getInstance().showProgress(requireActivity(), true)
            } else {
                ProgressDialogUtil.getInstance().hideProgress()
            }
        })
    }
    fun hitAlbumsList() {
        if (NetworkUtils.isInternetAvailable(requireActivity())) {

            albumsListViewModel.hitAlbumsList()

        } else {
            showToast("Please check your internet",requireContext())
        }
    }

}