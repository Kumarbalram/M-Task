package com.example.mobuloustask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobuloustask.databinding.PostItemBinding
import com.example.mobuloustask.model.AlbumsListResponse
import com.example.mobuloustask.model.PostListResponse

class AlbumsAdapter(val context: Context,val albumsList:ArrayList<AlbumsListResponse.AlbumsListResponseItem>):RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>(){

    class AlbumsViewHolder(val binding: PostItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        return AlbumsViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
      return albumsList.size
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        val list = albumsList[position]
       holder.binding.apply {
           tvId.text = list.id.toString()
           tvTitle.text = list.title
       }
    }
}