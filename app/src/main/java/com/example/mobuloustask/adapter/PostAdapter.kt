package com.example.mobuloustask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobuloustask.databinding.PostItemBinding
import com.example.mobuloustask.model.PostListResponse

class PostAdapter(val context: Context,val postList:ArrayList<PostListResponse.PostListResponseItem>):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(var binding: PostItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val list = postList[position]
       holder.binding.apply {
           tvId.text = list.id.toString()
           tvTitle.text = list.title
       }
    }
}