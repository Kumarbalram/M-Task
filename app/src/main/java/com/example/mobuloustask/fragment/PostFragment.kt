package com.example.mobuloustask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mobuloustask.adapter.PostAdapter
import com.example.mobuloustask.base.BaseFragment
import com.example.mobuloustask.databinding.FragmentPostBinding
import com.example.mobuloustask.model.PostListResponse
import com.example.mobuloustask.utils.ErrorUtil
import com.example.mobuloustask.utils.NetworkUtils
import com.example.mobuloustask.utils.ProgressDialogUtil
import com.example.mobuloustask.utils.showToast
import com.example.mobuloustask.viewmodel.PostViewModel


class PostFragment : BaseFragment() {
    private lateinit var binding: FragmentPostBinding
private lateinit var postViewModel:PostViewModel
private lateinit var adapter : PostAdapter
    override fun initView() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPostBinding.inflate(layoutInflater)
        postViewModel = ViewModelProvider(requireActivity())[PostViewModel::class.java]
        getPost()
        hitPostList()

        return binding.root
    }

    private fun getPost() {
        postViewModel.postListResponse.observe(requireActivity(), androidx.lifecycle.Observer {
            adapter = PostAdapter(requireContext(),it as ArrayList<PostListResponse.PostListResponseItem>)
            binding.postRecycler.adapter = adapter


        })
        postViewModel.errorPost.observe(requireActivity(), androidx.lifecycle.Observer {
            ProgressDialogUtil.getInstance().hideProgress()
            ErrorUtil.handlerGeneralError(requireActivity(), binding.postRecycler, it)
        })
        postViewModel.progressPost.observe(requireActivity(), androidx.lifecycle.Observer {
            if (it) {
                ProgressDialogUtil.getInstance().showProgress(requireActivity(), true)
            } else {
                ProgressDialogUtil.getInstance().hideProgress()
            }
        })
    }
    fun hitPostList() {
        if (NetworkUtils.isInternetAvailable(requireActivity())) {

            postViewModel.hitPostList()

        } else {
            showToast("Please check your internet",requireContext())
        }
    }


}