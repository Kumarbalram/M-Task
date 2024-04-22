package com.example.mobuloustask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobuloustask.databinding.PhotosItemBinding
import com.example.mobuloustask.model.PhotosListResponse

class PhotosAdapter(val context: Context,val photoList:ArrayList<PhotosListResponse.PhotosListResponseItem>):RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    class PhotosViewHolder(val binding: PhotosItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(PhotosItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return photoList.size
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val list = photoList[position]
        holder.binding.apply {
            Glide.with(context).load(list.url).into(img)
            tvTitle.text = list.title
        }
    }
}